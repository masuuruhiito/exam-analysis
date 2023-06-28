package com.shijw.front.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shijw.front.constant.CommonConstant;
import com.shijw.front.model.dto.CourseObjectiveDTO;
import com.shijw.front.model.dto.CourseObjectiveInfoDto;
import com.shijw.front.model.vo.QueryCourseVO;
import com.shijw.front.web.params.FrontCourseCreateParams;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class FrontPersonalCourse {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String courseId;

    private String courseName;

    private String courseObjectives;

    private String courseObjectivesInfo;

    private Double credits;

    private String courseCode;

    private String examWay;

    private String proportion;

    private String classHour;

    private String createUsername;

    public static QueryCourseVO toQueryCourseVo(FrontPersonalCourse personalCourse) {
        QueryCourseVO res = new QueryCourseVO();
        BeanUtils.copyProperties(personalCourse, res);
        res.setFrom(CommonConstant.INFO_FROM_PERSONAL);
        return res;
    }

    public Map<String, CourseObjectiveInfoDto.ObjectiveInfoDto> getEnglishScoreNameObjectivesInfoMap() {
        return CourseObjectiveInfoDto.toEnglishScoreNameMap(JSONArray.parseArray(courseObjectivesInfo, CourseObjectiveInfoDto.ObjectiveInfoDto.class));
    }

    public Map<String, CourseObjectiveInfoDto.ObjectiveInfoDto> getChineseScoreNameObjectivesInfoMap() {
        return CourseObjectiveInfoDto.toChineseScoreNameMap(JSONArray.parseArray(courseObjectivesInfo, CourseObjectiveInfoDto.ObjectiveInfoDto.class));
    }

    public List<CourseObjectiveDTO> getObjectivesList() {
        return JSONArray.parseArray(courseObjectives, CourseObjectiveDTO.class);
    }

    public FrontCourseCreateParams.ClassHourDto getClassHourDto() {
        return JSONObject.parseObject(classHour, FrontCourseCreateParams.ClassHourDto.class);
    }
}