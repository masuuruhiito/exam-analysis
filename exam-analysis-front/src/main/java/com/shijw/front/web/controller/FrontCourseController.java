package com.shijw.front.web.controller;

import com.shijw.front.aop.annotation.LoginValid;
import com.shijw.front.common.CommonPage;
import com.shijw.front.common.CommonResult;
import com.shijw.front.config.CommonConfig;
import com.shijw.front.model.vo.QueryCourseVO;
import com.shijw.front.model.vo.QueryScoreHeaderVO;
import com.shijw.front.service.IFrontCourseService;
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
@RequestMapping("/front/course")
@Api(tags = "FrontCourseController", description = "后台管理系统-课程管理模块")
public class FrontCourseController {

    @Autowired
    private IFrontCourseService frontCourseService;
    @Autowired
    private CommonConfig commonConfig;


    @ApiOperation(value = "查询当前全部课程信息")
    @GetMapping(value = "/queryCurAllCourse")
    @ResponseBody
    @LoginValid
    public CommonResult<CommonPage<QueryCourseVO>> queryCurAllCourse(
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer pageNum) {

        CommonPage<QueryCourseVO> resList = frontCourseService.queryCurAllCourse(pageSize, pageNum);
        return CommonResult.success(resList);
    }

    @ApiOperation(value = "创建个人课程信息")
    @PostMapping(value = "/registerPersonalCourse")
    @ResponseBody
    @LoginValid
    public CommonResult<String> registerPersonalCourse(
            @RequestBody FrontCourseCreateParams params) {

        frontCourseService.registerPersonalCourse(params);
        return CommonResult.success();
    }

    @ApiOperation(value = "创建对应课程的课程目标")
    @PostMapping(value = "/createCourseObjectives")
    @ResponseBody
    @LoginValid
    public CommonResult<String> createCourseObjectives(
            @RequestParam FrontCourseObjectivesCreateParams params) {

        frontCourseService.createCourseObjectives(params);
        return CommonResult.success();
    }

    @ApiOperation(value = "获取课程分数表头")
    @PostMapping(value = "/getCourseScoreShowHeader")
    @ResponseBody
    @LoginValid
    public CommonResult<List<QueryScoreHeaderVO>> getCourseScoreShowHeader(
            @RequestBody
            @Validated({ParamsSequenceValidator.class})
                    FrontQueryTeachInfoScoreParams params) {

        List<QueryScoreHeaderVO> res = frontCourseService.getCourseScoreShowHeader(params.getTeachInfoId());
        return CommonResult.success(res);
    }
}
