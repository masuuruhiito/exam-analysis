package com.shijw.back.web.params;

import com.shijw.back.aop.annotation.PhoneValid;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @author SHI
 * @date 2023/4/8 13:59
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BackStudentAddaStudentParams extends BaseUniversityCodeParams {

    @NotEmpty(message = "班级标识码不能为空！", groups = TheSecondValidProperty.class)
    private String classId;

    @NotEmpty(message = "学号不能为空！", groups = TheThirdValidProperty.class)
    private String studentId;

    @NotEmpty(message = "学生姓名不能为空！", groups = TheFourthValidProperty.class)
    private String studentName;

    @PhoneValid(message = "绑定手机号格式不正确！", groups = TheFifthValidProperty.class)
    private String studentTelephone;

    @Email(message = "绑定邮箱格式不正确！", groups = TheSixthValidProperty.class)
    private String studentEmail;
}