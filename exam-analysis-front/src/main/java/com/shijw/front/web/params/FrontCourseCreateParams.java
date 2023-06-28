package com.shijw.front.web.params;

import com.shijw.front.aop.annotation.ExcelHeaderInfo;
import com.shijw.front.model.dto.CourseObjectiveDTO;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author SHI
 * @date 2023/4/19 16:17
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FrontCourseCreateParams {
    private String courseName;
    private String courseCode;
    private String proportion;
    private String examWay;
    private ClassHourDto classHour;
    private double credits;
    private List<FrontCourseObjectivesCreateParams.CourseObjectiveDto> courseObjectives;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ClassHourDto {
        private int practice;
        private int clazz;
        private int computer;
        private int experiment;
    }
}