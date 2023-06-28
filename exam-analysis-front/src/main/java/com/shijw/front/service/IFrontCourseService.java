package com.shijw.front.service;

import com.shijw.front.common.CommonPage;
import com.shijw.front.model.vo.QueryCourseVO;
import com.shijw.front.model.vo.QueryScoreHeaderVO;
import com.shijw.front.web.params.FrontCourseCreateParams;
import com.shijw.front.web.params.FrontCourseObjectivesCreateParams;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/12 21:26
 */
public interface IFrontCourseService {

    CommonPage<QueryCourseVO> queryCurAllCourse(Integer pageSize, Integer pageNum);

    void registerPersonalCourse(FrontCourseCreateParams params);

    void createCourseObjectives(FrontCourseObjectivesCreateParams params);

    List<QueryScoreHeaderVO> getCourseScoreShowHeader(String teachInfoId);
}