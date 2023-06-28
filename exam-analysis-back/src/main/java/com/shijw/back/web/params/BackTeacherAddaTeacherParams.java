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
public class BackTeacherAddaTeacherParams extends BaseUniversityCodeParams {

    @NotEmpty(message = "学院标识码不能为空！", groups = TheSecondValidProperty.class)
    private String collegeId;

    @NotEmpty(message = "教师姓名不能为空！", groups = TheThirdValidProperty.class)
    private String teacherName;

    @PhoneValid(message = "绑定手机号格式不正确！", groups = TheFourthValidProperty.class)
    private String teacherTelephone;

    @Email(message = "绑定邮箱格式不正确！", groups = TheFifthValidProperty.class)
    private String teacherEmail;
}