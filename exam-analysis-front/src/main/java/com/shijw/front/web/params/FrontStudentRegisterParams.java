package com.shijw.front.web.params;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author SHI
 * @date 2023/4/13 22:49
 */
@Data
public class FrontStudentRegisterParams {

    @NotEmpty(message = "班级标识码不能为空！", groups = TheFirstValidProperty.class)
    private String classId;
    @NotEmpty(message = "学生学号不能为空！", groups = TheSecondValidProperty.class)
    private String studentId;
    @NotEmpty(message = "学生姓名不能为空！", groups = TheThirdValidProperty.class)
    private String studentName;

    private String sex;

    private String birthday;

    private String phoneNumber;

    private String email;

    private String address;
}
