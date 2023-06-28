package com.shijw.front.web.params;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * @author SHI
 * @date 2023/4/8 13:59
 */
@Data
public class FrontCourseRegisterParams {

    @NotEmpty(message = "课程名称不能为空！", groups = TheSecondValidProperty.class)
    private String courseName;
}