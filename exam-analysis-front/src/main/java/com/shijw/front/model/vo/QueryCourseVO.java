package com.shijw.front.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author SHI
 * @date 2023/4/12 21:30
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class QueryCourseVO {

    private Integer id;

    private String courseName;

    private String courseId;

    private String courseObjectives;

    private String courseObjectivesInfo;

    private Double credits;

    private String courseCode;

    private String examWay;

    private String proportion;

    private String classHour;

    private String from;
}
