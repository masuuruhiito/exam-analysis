package com.shijw.front.aop;

import com.shijw.front.aop.annotation.LoginValid;
import com.shijw.front.config.CommonConfig;
import com.shijw.front.constant.CommonConstant;
import com.shijw.front.enums.FrontBusinessExceptionEnum;
import com.shijw.front.exception.FrontBusinessException;
import com.shijw.front.mapper.FrontUserMapper;
import com.shijw.front.model.FrontUser;
import com.shijw.front.service.IFrontUserService;
import com.shijw.front.service.ITokenService;
import com.shijw.front.utils.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


/**
 * 校验接口签名
 *
 * @author zgy
 * @version 1.0
 * @date 2021/4/18
 */
@Component
@Aspect
@Slf4j
public class LoginValidAspect {
    @Autowired
    private CommonConfig commonConfig;
    @Autowired
    private ITokenService tokenService;
    @Autowired
    private IFrontUserService frontUserService;


    @Before("@annotation(com.shijw.front.aop.annotation.LoginValid)")
    public void validSign(JoinPoint joinPoint) {
        HttpServletRequest request = CommonUtil.getRequest();
        String requestMethod = request.getMethod();
        // 获取注解中的参数值
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        LoginValid annotation = methodSignature.getMethod().getAnnotation(LoginValid.class);
        // 根据 loginValid属性 判断是否需要 检查登录状态
        loginValid(annotation, joinPoint, requestMethod);
    }

    public void loginValid(LoginValid annotation, JoinPoint joinPoint, String requestMethod) {
        if (!annotation.loginValid()) {
            return;
        }
        String token = tokenService.getTokenFromRequestHead();
        String userName = tokenService.getUsernameFromRequestHead();
        FrontUser user = frontUserService.getUserByUsername(userName);
        if (user == null) {
            throw new FrontBusinessException(FrontBusinessExceptionEnum.TOKEN_ERROR_EXCEPTION);
        }
        // 通过密码校验 token 是否正确
        if (!tokenService.checkSign(token, user.getPassword())) {
            throw new FrontBusinessException(FrontBusinessExceptionEnum.TOKEN_CHECK_FAIL_EXCEPTION);
        }
    }
}
