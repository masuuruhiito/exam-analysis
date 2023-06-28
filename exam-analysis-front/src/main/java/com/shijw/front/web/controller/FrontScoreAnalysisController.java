package com.shijw.front.web.controller;

import com.shijw.front.aop.annotation.LoginValid;
import com.shijw.front.service.IFrontScoreAnalysisService;
import com.shijw.front.web.params.FrontScoreAnalysisParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author SHI
 * @date 2023/4/14 22:43
 */
@RestController
@CrossOrigin//跨域访问
@RequestMapping("/front/score/analysis")
@Api(tags = "FrontCourseController", description = "后台管理系统-成绩分析模块")
public class FrontScoreAnalysisController {
    @Autowired
    private IFrontScoreAnalysisService frontScoreAnalysisService;


    @ApiOperation(value = "导出记分册")
    @GetMapping(value = "/exportScoreBook")
    @ResponseBody
    @LoginValid
    public void exportScoreBook(@Validated FrontScoreAnalysisParams params) {

        frontScoreAnalysisService.exportScoreBook(params);
    }

    @ApiOperation(value = "导出达成度计算表")
    @GetMapping(value = "/exportAchievementLevelCalculateTable")
    @ResponseBody
    @LoginValid
    public void exportAchievementLevelCalculateTable(
            @Validated FrontScoreAnalysisParams params) {

        frontScoreAnalysisService.exportAchievementLevelCalculateTable(params);
    }

    @ApiOperation(value = "导出教学档案存档内容")
    @GetMapping(value = "/exportTeachingRecord")
    @ResponseBody
//    @LoginValid
    public void exportTeachingRecord(
            @Validated FrontScoreAnalysisParams params) {

        frontScoreAnalysisService.exportTeachingRecord(params);
    }
}
