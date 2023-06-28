package com.shijw.back.web.controller;

import com.shijw.back.aop.annotation.LoginValid;
import com.shijw.back.common.CommonResult;
import com.shijw.back.model.BackStudent;
import com.shijw.back.service.IBackBatchOperationService;
import com.shijw.back.service.IBackStudentService;
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
@RequestMapping("/back/student")
@Api(tags = "BackStudentController", description = "后台管理系统-学生模块")
public class BackStudentController {

    @Autowired
    private IBackStudentService backStudentService;
    @Autowired
    private IBackBatchOperationService backBatchOperationService;


    @ApiOperation(value = "查询全部当前班级的全部学生")
    @PostMapping(value = "/queryByClassId")
    @ResponseBody
    @LoginValid(identityValid = true, lowestIdentity = 1)
    public CommonResult<List<BackStudent>> queryByClassId(@RequestBody
                                                          @Validated({ParamsSequenceValidator.class})
                                                                  BackStudentQueryByClassIdParams params) {

        List<BackStudent> studentList = backStudentService.queryByClassId(params);
        return CommonResult.success(studentList);
    }

    @ApiOperation(value = "添加班级学生")
    @PostMapping(value = "/addaStudent")
    @ResponseBody
    @LoginValid(identityValid = true, lowestIdentity = 1)
    public CommonResult<String> addStudent(@RequestBody
                                           @Validated({ParamsSequenceValidator.class})
                                                   BackStudentAddaStudentParams params) {

        backStudentService.addaStudent(params);
        return CommonResult.success();
    }

    @ApiOperation(value = "批量添加班级学生")
    @PostMapping(value = "/batchAddStudentByInput")
    @ResponseBody
    @LoginValid(identityValid = true, lowestIdentity = 1)
    public CommonResult<String> batchAddStudentByInput(@RequestBody
                                                       @Validated({ParamsSequenceValidator.class})
                                                               List<BackStudentAddaStudentParams> paramsList) {

        backBatchOperationService.batchAddStudentByInput(paramsList);
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
