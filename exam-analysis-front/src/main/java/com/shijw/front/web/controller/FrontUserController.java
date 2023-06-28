package com.shijw.front.web.controller;

import com.google.common.collect.ImmutableMap;
import com.shijw.front.aop.annotation.LoginValid;
import com.shijw.front.common.CommonResult;
import com.shijw.front.model.vo.UserInfoVO;
import com.shijw.front.service.IFrontUserService;
import com.shijw.front.web.params.FrontUpdateUserInfoParams;
import com.shijw.front.web.params.FrontUserLoginParams;
import com.shijw.front.web.params.FrontUserRegisterParams;
import com.shijw.front.web.params.ParamsSequenceValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SHI
 * @date 2023/4/6 23:30
 */
@RestController
@CrossOrigin//跨域访问
@RequestMapping("/front/user")
@Api(tags = "Back-User-Controller", description = "后台管理系统-用户模块")
public class FrontUserController {

    @Autowired
    private IFrontUserService frontUserService;


    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    @ResponseBody
    public CommonResult<String> register(@RequestBody
                                         @Validated({ParamsSequenceValidator.class})
                                                 FrontUserRegisterParams params) {

        frontUserService.register(params);
        return CommonResult.success();
    }

    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/login")
    @ResponseBody
    public CommonResult<Map<String, String>> login(@RequestBody
                                                   @Validated({ParamsSequenceValidator.class})
                                                           FrontUserLoginParams params) {

        String token = frontUserService.login(params);
        return CommonResult.success(ImmutableMap.of("token", token));
    }

    @GetMapping("/info")
    @ApiOperation(value = "获取当前登录用户信息主界面")
    @ResponseBody
    @LoginValid
    public CommonResult<UserInfoVO> getAdminInfo() {
        //登录成功后主界面
        UserInfoVO res = frontUserService.info();
        return CommonResult.success(res);
    }

    @PostMapping("/updateInfo")
    @ApiOperation(value = "获取当前登录用户信息主界面")
    @ResponseBody
    @LoginValid
    public CommonResult<UserInfoVO> updateInfo(@RequestBody
                                               @Validated({ParamsSequenceValidator.class})
                                                       FrontUpdateUserInfoParams params) {
        //登录成功后主界面
        frontUserService.updateInfo(params);
        return CommonResult.success();
    }
}
