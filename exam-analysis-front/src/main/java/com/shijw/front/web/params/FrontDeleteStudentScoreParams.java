package com.shijw.front.web.params;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author SHI
 * @date 2023/5/20 0:28
 */
@Data
public class FrontDeleteStudentScoreParams {
    @NotEmpty(message = "教授关系标识码不能为空！", groups = TheFirstValidProperty.class)
    private String teachInfoId;

    @NotEmpty(message = "学生ID不能为空！", groups = TheSecondValidProperty.class)
    private String studentId;
}
