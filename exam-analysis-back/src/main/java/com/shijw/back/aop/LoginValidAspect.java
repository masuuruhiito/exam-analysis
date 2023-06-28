package com.shijw.back.aop;

import com.shijw.back.aop.annotation.LoginValid;
import com.shijw.back.config.CommonConfig;
import com.shijw.back.constant.CommonConstant;
import com.shijw.back.enums.BackBusinessExceptionEnum;
import com.shijw.back.enums.BackExceptionEnum;
import com.shijw.back.exception.BackBusinessException;
import com.shijw.back.exception.BackException;
import com.shijw.back.mapper.BackUniversityMapper;
import com.shijw.back.model.BackUniversity;
import com.shijw.back.model.BackUniversityExample;
import com.shijw.back.model.BackUser;
import com.shijw.back.service.IBackUserService;
import com.shijw.back.service.ITokenService;
import com.shijw.back.utils.CommonUtil;
import com.shijw.back.web.params.BaseUniversityCodeParams;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


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
    private IBackUserService backUserService;
    @Autowired
    private ITokenService tokenService;
    @Autowired
    private BackUniversityMapper backUniversityMapper;


    @Before("@annotation(com.shijw.back.aop.annotation.LoginValid)")
    public void validSign(JoinPoint joinPoint) {
        HttpServletRequest request = CommonUtil.getRequest();
        String requestMethod = request.getMethod();
        //从http头部取出token
        String token = request.getHeader(commonConfig.getJwtTokenHeader());
        // 获取注解中的参数值
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        LoginValid annotation = methodSignature.getMethod().getAnnotation(LoginValid.class);
        // 根据 loginValid属性 判断是否需要 检查登录状态
        loginValid(annotation, token, joinPoint, requestMethod);
    }

    public void loginValid(LoginValid annotation, String token, JoinPoint joinPoint, String requestMethod) {
        if (!annotation.loginValid()) {
            return;
        }
        token = tokenService.getRemoveTokenHeadToken(token);
        BackUser user = backUserService.queryUserByToken(token);
        if (user == null) {
            throw new BackBusinessException(BackBusinessExceptionEnum.TOKEN_ERROR_EXCEPTION);
        }
        // 通过密码校验 token 是否正确
        if (!tokenService.checkSign(token, user.getPassword())) {
            throw new BackBusinessException(BackBusinessExceptionEnum.TOKEN_CHECK_FAIL_EXCEPTION);
        }

        // 根据 loginValid属性 判断是否需要 检查操作权限
        identityValid(annotation, user, joinPoint, requestMethod);
    }

    public void identityValid(LoginValid annotation, BackUser user, JoinPoint joinPoint, String requestMethod) {

        // todo  需重订规则
        if (!annotation.identityValid()) {
            return;
        }
        Integer curUserIdentity = user.getIdentity();
        Integer lowestIdentity = annotation.lowestIdentity();
        if (curUserIdentity > lowestIdentity || curUserIdentity == 2) {
            throw new BackBusinessException(BackBusinessExceptionEnum.CUR_USER_PERMISSION_TOO_LOW_EXCEPTION);
        }

        validOperationUniversityCodeList(joinPoint, curUserIdentity, requestMethod);

        // 获取操作学校的唯一标识码
        String operationUniversityCode = null;
        if (CommonConstant.HTTP_REQUEST_TYPE_GET.equals(requestMethod)) {
            operationUniversityCode = getOperationUniversityIdListFromGetRequest(joinPoint, curUserIdentity);
        } else if (CommonConstant.HTTP_REQUEST_TYPE_POST.equals(requestMethod)) {
            operationUniversityCode = getOperationUniversityIdFromPostRequest(joinPoint, curUserIdentity);
        }

        // 校验学校唯一标识码是否正确
        if (StringUtils.isEmpty(operationUniversityCode)
                || !containsCurUniversityCode(user.getUniversityCode())) {
            throw new BackBusinessException(BackBusinessExceptionEnum.CANNOT_OPERATE_A_SCHOOL_THAT_IS_NOT_REGISTERED_EXCEPTION);
        }
        // 学校管理员需验证操作学校与所属学校是否匹配，系统管理员不需判断
        if (1 == curUserIdentity) {
            if (!operationUniversityCode.equals(user.getUniversityCode())) {
                throw new BackBusinessException(BackBusinessExceptionEnum.USER_UNIVERSITY_DONT_MATCH_OPERATION_UNIVERSITY_EXCEPTION);
            }
        }
    }

    private void validOperationUniversityCodeList(JoinPoint joinPoint, Integer curUserIdentity, String requestMethod) {

    }

    private String getOperationUniversityIdListFromGetRequest(JoinPoint joinPoint, Integer curUserIdentity) {
        String[] argNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        boolean containsUniversityCode = false;
        int universityCodeIndex;
        for (universityCodeIndex = 0; universityCodeIndex < argNames.length; universityCodeIndex++) {
            if (CommonConstant.FUNC_PARAM_NAME_OF_UNIVERSITY_CODE.equals(argNames[universityCodeIndex])) {
                containsUniversityCode = true;
                break;
            }
        }
        if (!containsUniversityCode) {
            throw new BackException(BackExceptionEnum.CUR_FUNC_HAVE_NO_UNIVERSITY_ID_EXCEPTION);
        }
        return (String) joinPoint.getArgs()[universityCodeIndex];
    }

    private String getOperationUniversityIdFromPostRequest(JoinPoint joinPoint, Integer curUserIdentity) {
        Object[] args = joinPoint.getArgs();
        return ((BaseUniversityCodeParams) args[0]).getUniversityCode();
    }

    private boolean containsCurUniversityCode(String universityCode) {
        BackUniversityExample example = new BackUniversityExample();
        example.createCriteria().andUniversityCodeEqualTo(universityCode);
        List<BackUniversity> universities = backUniversityMapper.selectByExample(example);
        return !CollectionUtils.isEmpty(universities);
    }
}
