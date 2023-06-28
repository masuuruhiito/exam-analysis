package com.shijw.front.web.controller;

import com.shijw.front.aop.annotation.LoginValid;
import com.shijw.front.common.CommonResult;
import com.shijw.front.model.vo.QueryTeachInfoVO;
import com.shijw.front.service.IFrontTeachInfoService;
import com.shijw.front.web.params.FrontAddTeachInfoParams;
import com.shijw.front.web.params.FrontQueryTeachInfoParams;
import com.shijw.front.web.params.ParamsSequenceValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author SHI
 * @date 2023/5/17 13:20
 */
@RestController
@CrossOrigin//跨域访问
@RequestMapping("/front/teachInfo")
@Api(tags = "FrontTeachInfoController", description = "前台管理系统-任教信息管理")
public class FrontTeachInfoController {

    @Autowired
    private IFrontTeachInfoService frontTeachInfoService;

    @ApiOperation(value = "查询任教信息")
    @PostMapping(value = "/queryTeachInfoByConditions")
    @ResponseBody
    @LoginValid(identityValid = true, lowestIdentity = 1)
    public CommonResult<List<QueryTeachInfoVO>> queryTeachInfoByConditions(
            @RequestBody
            @Validated({ParamsSequenceValidator.class})
                    FrontQueryTeachInfoParams params) {

        List<QueryTeachInfoVO> resList = frontTeachInfoService.queryTeachInfoByConditions(params);
        return CommonResult.success(resList);
    }

    @ApiOperation(value = "添加任教信息")
    @PostMapping(value = "/addTeachInfo")
    @ResponseBody
    @LoginValid(identityValid = true, lowestIdentity = 1)
    public CommonResult<String> addTeachInfo(
            @RequestBody
            @Validated({ParamsSequenceValidator.class})
                    FrontAddTeachInfoParams params) {

        frontTeachInfoService.addTeachInfo(params);
        return CommonResult.success();
    }
}
