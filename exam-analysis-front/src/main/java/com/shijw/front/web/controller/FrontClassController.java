package com.shijw.front.web.controller;

import com.shijw.front.aop.annotation.LoginValid;
import com.shijw.front.common.CommonResult;
import com.shijw.front.config.CommonConfig;
import com.shijw.front.model.vo.QueryClassVO;
import com.shijw.front.service.IFrontClassService;
import com.shijw.front.web.params.FrontClassQueryClassByConditionsParams;
import com.shijw.front.web.params.FrontClassRegisterParams;
import com.shijw.front.web.params.FrontClassUpdateParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/12 21:16
 */
@RestController
@CrossOrigin//跨域访问
@RequestMapping("/front/class")
@Api(tags = "FrontCourseController", description = "后台管理系统-班级管理")
public class FrontClassController {

    @Autowired
    private IFrontClassService frontClassService;
    @Autowired
    private CommonConfig commonConfig;

    @ApiOperation(value = "按照条件查询学校班级")
    @PostMapping(value = "/queryClassByConditions")
    @ResponseBody
    @LoginValid
    // tongguo 学院、专业、年级、班级、是否绑定教授关系、数据来源、进行筛选
    public CommonResult<List<QueryClassVO>> queryClassByConditions(
            @RequestBody FrontClassQueryClassByConditionsParams params
    ) {

        // todo 查询班级需附带班级人数
        List<QueryClassVO> resList = frontClassService.queryClassByConditions(params);
        return CommonResult.success(resList);
    }

    @ApiOperation(value = "创建个人班级信息")
    @PostMapping(value = "/registerPersonalClass")
    @ResponseBody
    @LoginValid
    public CommonResult<String> registerPersonalClass(
            @RequestBody FrontClassRegisterParams params
    ) {

        frontClassService.registerPersonalClass(params);
        return CommonResult.success();
    }

    @ApiOperation(value = "更新个人班级信息")
    @PostMapping(value = "/updatePersonalClass")
    @ResponseBody
//    @LoginValid
    public CommonResult<String> updatePersonalClass(
            @RequestBody FrontClassUpdateParams params) {

        frontClassService.updatePersonalClass(params);
        return CommonResult.success();
    }
}
