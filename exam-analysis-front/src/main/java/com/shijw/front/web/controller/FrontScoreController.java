package com.shijw.front.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.shijw.front.aop.annotation.LoginValid;
import com.shijw.front.common.CommonResult;
import com.shijw.front.model.vo.QueryScoreVO;
import com.shijw.front.service.IFrontScoreService;
import com.shijw.front.web.params.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author SHI
 * @date 2023/4/12 21:16
 */
@RestController
@CrossOrigin//跨域访问
@RequestMapping("/front/score/operation")
@Api(tags = "FrontScoreController", description = "后台管理系统-成绩管理")
public class FrontScoreController {

    @Autowired
    private IFrontScoreService frontScoreService;

    @ApiOperation(value = "下载上传成绩模板")
    @GetMapping(value = "/downloadScoreExcelTemplate")
    @ResponseBody
//    @LoginValid
    public CommonResult<String> downloadScoreExcelTemplate(@RequestParam("teachInfoId") String teachInfoId) {

        // todo 下载上传成绩模板
        frontScoreService.downloadScoreExcelTemplate(teachInfoId);
        return CommonResult.success();
    }

    @ApiOperation(value = "上传班级课程成绩Excel")
    @PostMapping(value = "/uploadScoreByExcel")
    @ResponseBody
    @LoginValid
    public CommonResult<String> uploadScoreByExcel(
            @Validated({ParamsSequenceValidator.class})
                    FrontScoreUploadScoreByExcelParams params) {

        frontScoreService.uploadScoreByExcel(params);
        return CommonResult.success();
    }

    @ApiOperation(value = "查询班级课程成绩")
    @PostMapping(value = "/queryTeachInfoScores")
    @ResponseBody
    @LoginValid
    public CommonResult<JSONArray> queryTeachInfoScores(
            @RequestBody
            @Validated({ParamsSequenceValidator.class})
                    FrontQueryTeachInfoScoreParams params) {

        JSONArray resList = frontScoreService.queryTeachInfoScores(params);
        return CommonResult.success(resList);
    }

    @ApiOperation(value = "添加单个学生成绩")
    @PostMapping(value = "/addStudentScores")
    @ResponseBody
    @LoginValid
    public CommonResult<String> addStudentScores(
            @RequestBody
            @Validated({ParamsSequenceValidator.class})
                    FrontAddStudentScoreParams params
    ) {

        frontScoreService.addStudentScores(params);
        return CommonResult.success();
    }

    @ApiOperation(value = "修改单个学生成绩")
    @PostMapping(value = "/updateStudentScores")
    @ResponseBody
    @LoginValid
    public CommonResult<String> updateStudentScores(
            @RequestBody
            @Validated({ParamsSequenceValidator.class})
                    FrontAddStudentScoreParams params
    ) {

        frontScoreService.updateStudentScores(params);
        return CommonResult.success();
    }

    @ApiOperation(value = "删除单个学生成绩")
    @PostMapping(value = "/deleteStudentScores")
    @ResponseBody
    @LoginValid
    public CommonResult<String> deleteStudentScores(
            @RequestBody
            @Validated({ParamsSequenceValidator.class})
                    FrontDeleteStudentScoreParams params
    ) {

        frontScoreService.deleteStudentScores(params);
        return CommonResult.success();
    }
}
