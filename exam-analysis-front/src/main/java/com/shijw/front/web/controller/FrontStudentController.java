package com.shijw.front.web.controller;

import com.shijw.front.aop.annotation.LoginValid;
import com.shijw.front.common.CommonResult;
import com.shijw.front.config.CommonConfig;
import com.shijw.front.model.vo.QueryStudentVO;
import com.shijw.front.service.IFrontStudentService;
import com.shijw.front.web.params.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/12 21:16
 */
@RestController
@CrossOrigin//跨域访问
@RequestMapping("/front/student")
@Api(tags = "FrontStudentController", description = "后台管理系统-学生管理")
public class FrontStudentController {

    @Autowired
    private IFrontStudentService frontStudentService;
    @Autowired
    private CommonConfig commonConfig;

    @ApiOperation(value = "按照条件查询班级学生")
    @PostMapping(value = "/queryStudentsByTeachInfoId")
    @ResponseBody
    @LoginValid
    public CommonResult<List<QueryStudentVO>> queryStudentsByTeachInfoId(
            @RequestBody
            @Validated({ParamsSequenceValidator.class})
                    FrontStudentQueryByTeachInfoIdParams params) {

        List<QueryStudentVO> resList = frontStudentService.queryStudentsByTeachInfoId(params);
        return CommonResult.success(resList);
    }

    @ApiOperation(value = "按照条件查询班级学生")
    @PostMapping(value = "/queryStudentsByClassId")
    @ResponseBody
    @LoginValid
    public CommonResult<List<QueryStudentVO>> queryStudentsByClassId(
            @RequestBody FrontStudentQueryByClassIdParams params) {

        List<QueryStudentVO> resList = frontStudentService.queryStudentsByClassId(params.getClassId());
        return CommonResult.success(resList);
    }

    @ApiOperation(value = "批量上传个人班级学生信息")
    @PostMapping(value = "/registerPersonalStudentsOfClassByExcel")
    @ResponseBody
    @LoginValid
    public CommonResult<String> registerPersonalStudentsOfClassByExcel(
            @Validated({ParamsSequenceValidator.class}) FrontStudentRegisterByExcelParams params
    ) {

        frontStudentService.registerPersonalStudentsOfClassByExcel(params);
        return CommonResult.success();
    }

    @ApiOperation(value = "下载上传个人班级学生信息Excel模板")
    @GetMapping(value = "/getStudentInfoExcelTemplate")
    @ResponseBody
//    @LoginValid
    public void getStudentInfoExcelTemplate() {
        frontStudentService.getStudentInfoExcelTemplate();
    }

    @ApiOperation(value = "创建个人学生信息")
    @PostMapping(value = "/registerPersonalStudent")
    @ResponseBody
    @LoginValid
    public CommonResult<String> registerPersonalStudent(
            @RequestBody FrontStudentRegisterParams params
    ) {

        frontStudentService.registerPersonalStudent(params);
        return CommonResult.success();
    }

//    @ApiOperation(value = "更新个人班级信息")
//    @PostMapping(value = "/updatePersonalClass")
//    @ResponseBody
////    @LoginValid
//    public CommonResult<String> updatePersonalClass(
//            @RequestBody FrontClassUpdateParams params) {
//
//        frontClassService.updatePersonalClass(params);
//        return CommonResult.success();
//    }
}
