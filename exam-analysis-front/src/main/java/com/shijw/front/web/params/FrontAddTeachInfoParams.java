package com.shijw.front.web.params;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author SHI
 * @date 2023/4/13 22:49
 */
@Data
public class FrontAddTeachInfoParams {

    private String teacherId;

    @NotEmpty(message = "课程不能为空！", groups = TheFirstValidProperty.class)
    private String courseId;

    @NotEmpty(message = "班级不能为空！", groups = TheSecondValidProperty.class)
    private String classId;

    @NotEmpty(message = "学期不能为空！", groups = TheThirdValidProperty.class)
    private String semester;
}
