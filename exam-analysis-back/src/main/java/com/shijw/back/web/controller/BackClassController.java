package com.shijw.back.web.controller;

import com.shijw.back.aop.annotation.LoginValid;
import com.shijw.back.common.CommonResult;
import com.shijw.back.model.BackClass;
import com.shijw.back.model.BackUniversity;
import com.shijw.back.service.IBackClassService;
import com.shijw.back.web.params.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/6 11:18
 */
@RestController
@CrossOrigin//跨域访问
@RequestMapping("/back/class")
@Api(tags = "BackClassController", description = "后台管理系统-班级模块")
public class BackClassController {

    @Autowired
    private IBackClassService backClassService;


    @ApiOperation(value = "查询当前学院全部班级")
    @PostMapping(value = "/queryClassByCollegeId")
    @ResponseBody
    @LoginValid(identityValid = true, lowestIdentity = 1)
    public CommonResult<List<BackClass>> queryClassByCollegeId(
            @RequestBody
            @Validated({ParamsSequenceValidator.class})
                    BackClassQueryClassByCollegeIdParams params) {

        List<BackClass> classes = backClassService.queryClassByCollegeId(params);
        return CommonResult.success(classes);
    }

    @ApiOperation(value = "注册新学校")
    @PostMapping(value = "/register")
    @ResponseBody
    @LoginValid(identityValid = true, lowestIdentity = 1)
    public CommonResult<String> register(@RequestBody
                                         @Validated({ParamsSequenceValidator.class})
                                                 BackClassRegisterParams params) {

        backClassService.register(params);
        return CommonResult.success();
    }

    @ApiOperation(value = "删除学校")
    @RequestMapping(value = "/delete")
    @ResponseBody
    @LoginValid(identityValid = true, lowestIdentity = 0)
    public String delete() {
        return "success";
    }

    @ApiOperation(value = "更新学校信息")
    @RequestMapping(value = "/update")
    @ResponseBody
    public String update() {
        return "success";
    }
}
