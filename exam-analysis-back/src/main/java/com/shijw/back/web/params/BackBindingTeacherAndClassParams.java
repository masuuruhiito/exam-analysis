package com.shijw.back.web.params;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * @author SHI
 * @date 2023/4/11 20:00
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BackBindingTeacherAndClassParams extends BaseUniversityCodeParams {

    @NotEmpty(message = "教师号不能为空！", groups = TheSecondValidProperty.class)
    private String teacherId;

    @NotEmpty(message = "教授学科名称不能为空！", groups = TheThirdValidProperty.class)
    private String subjectName;

    @NotEmpty(message = "班级标识码不能为空！", groups = TheFourthValidProperty.class)
    private String classId;
}
