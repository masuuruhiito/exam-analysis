package com.shijw.back.web.controller;

import com.shijw.back.aop.annotation.LoginValid;
import com.shijw.back.common.CommonResult;
import com.shijw.back.model.BackUniversity;
import com.shijw.back.service.IBackUniversityService;
import com.shijw.back.web.params.BackUniversityQueryParams;
import com.shijw.back.web.params.BackUniversityRegisterParams;
import com.shijw.back.web.params.ParamsSequenceValidator;
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
@RequestMapping("/back/university")
@Api(tags = "UniversityController", description = "后台管理系统-学校模块")
public class BackUniversityController {

    @Autowired
    private IBackUniversityService backUniversityService;


    @ApiOperation(value = "查询全部学校")
    @GetMapping(value = "/queryAll")
    @ResponseBody
    @LoginValid(identityValid = true, lowestIdentity = 0)
    public CommonResult<List<BackUniversity>> queryAll() {

        List<BackUniversity> universities = backUniversityService.queryAll();
        return CommonResult.success(universities);
    }

    @ApiOperation(value = "注册新学校")
    @PostMapping(value = "/register")
    @ResponseBody
    @LoginValid(identityValid = true, lowestIdentity = 0)
    public CommonResult<String> register(@RequestBody
                                         @Validated({ParamsSequenceValidator.class})
                                                 BackUniversityRegisterParams params) {

        backUniversityService.register(params);
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


    @ApiOperation(value = "查询单个学校")
    @GetMapping(value = "/query")
    @ResponseBody
    @LoginValid(identityValid = true, lowestIdentity = 0)
    public CommonResult<BackUniversity> query(BackUniversityQueryParams params) {

        BackUniversity universities = backUniversityService.query(params);
        return CommonResult.success(universities);
    }
}
