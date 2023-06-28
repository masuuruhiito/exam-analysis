package com.shijw.back.web.controller;

import com.google.common.collect.ImmutableMap;
import com.shijw.back.aop.annotation.LoginValid;
import com.shijw.back.common.CommonResult;
import com.shijw.back.service.IBackUserService;
import com.shijw.back.web.params.BackUserLoginParams;
import com.shijw.back.web.params.BackUserRegisterParams;
import com.shijw.back.web.params.ParamsSequenceValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author SHI
 * @date 2023/4/6 23:30
 */
@RestController
@CrossOrigin//跨域访问
@RequestMapping("/back/user")
@Api(tags = "Back-User-Controller", description = "后台管理系统-用户模块")
public class BackUserController {

    @Autowired
    private IBackUserService backUserService;


    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    @ResponseBody
    public CommonResult<String> register(@RequestBody
                                         @Validated({ParamsSequenceValidator.class})
                                                 BackUserRegisterParams backUser) {

        backUserService.register(backUser);
        return CommonResult.success();
    }

    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/login")
    @ResponseBody
    public CommonResult<Map<String, String>> login(@RequestBody
                                                   @Validated({ParamsSequenceValidator.class})
                                                           BackUserLoginParams params) {

        String token = backUserService.login(params);
        return CommonResult.success(ImmutableMap.of("token", token));
    }

    @ApiOperation(value = "获取用户登录信息")
    @PostMapping(value = "/info")
    @ResponseBody
    @LoginValid
    public CommonResult<Map<String, String>> info() {
        // todo user/info
        System.out.println("11111");
        return CommonResult.success();
    }

    @ApiOperation(value = "退出登录")
    @PostMapping(value = "/loginOut")
    @ResponseBody
    public CommonResult<Map<String, String>> loginOut() {

        return CommonResult.success();
    }
}
