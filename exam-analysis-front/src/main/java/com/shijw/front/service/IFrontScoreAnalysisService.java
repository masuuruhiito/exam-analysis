package com.shijw.front.service;

import com.shijw.front.model.dto.CourseClassScoreInfoDTO;
import com.shijw.front.web.params.FrontScoreAnalysisParams;

/**
 * @author SHI
 * @date 2023/4/15 12:07
 */
public interface IFrontScoreAnalysisService {

    void exportScoreBook(FrontScoreAnalysisParams params);

    void exportAchievementLevelCalculateTable(FrontScoreAnalysisParams params);

    CourseClassScoreInfoDTO getCourseClassScoreInfoDtoByTeachInfoId(String teachInfoId);

    void exportTeachingRecord(FrontScoreAnalysisParams params);
}
