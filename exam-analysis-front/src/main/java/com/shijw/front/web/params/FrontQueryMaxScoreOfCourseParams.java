package com.shijw.front.web.params;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author SHI
 * @date 2023/5/18 13:44
 */
@Data
public class FrontQueryMaxScoreOfCourseParams {

    @NotEmpty(message = "课程不能为空！", groups = TheFirstValidProperty.class)
    private String courseId;
}
