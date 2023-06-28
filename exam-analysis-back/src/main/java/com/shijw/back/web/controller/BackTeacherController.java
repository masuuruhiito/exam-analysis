package com.shijw.back.web.controller;

import com.shijw.back.aop.annotation.LoginValid;
import com.shijw.back.common.CommonResult;
import com.shijw.back.service.IBackTeacherService;
import com.shijw.back.web.params.BackBindingTeacherAndClassParams;
import com.shijw.back.web.params.BackTeacherAddaTeacherParams;
import com.shijw.back.web.params.ParamsSequenceValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author SHI
 * @date 2023/4/11 19:21
 */
@RestController
@CrossOrigin//跨域访问
@RequestMapping("/back/teacher")
@Api(tags = "BackTeacherController", description = "后台管理系统-教师模块")
public class BackTeacherController {

    @Autowired
    private IBackTeacherService backTeacherService;

    @ApiOperation(value = "注册教师信息")
    @PostMapping(value = "/batchAddStudentByInput")
    @ResponseBody
    @LoginValid(identityValid = true, lowestIdentity = 1)
    public CommonResult<String> register(@RequestBody
                                         @Validated({ParamsSequenceValidator.class})
                                                 BackTeacherAddaTeacherParams params) {

        backTeacherService.addaTeacher(params);
        return CommonResult.success();
    }

    @ApiOperation(value = "绑定教师班级信息")
    @PostMapping(value = "/bindingTeacherAndClass")
    @ResponseBody
    @LoginValid(identityValid = true, lowestIdentity = 1)
    public CommonResult<String> bindingTeacherAndClass(
            @RequestBody
            @Validated({ParamsSequenceValidator.class})
                    BackBindingTeacherAndClassParams params) {

        backTeacherService.bindingTeacherAndClass(params);
        return CommonResult.success();
    }
}
