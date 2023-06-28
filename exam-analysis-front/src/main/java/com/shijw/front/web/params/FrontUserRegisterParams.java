package com.shijw.front.web.params;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * @author SHI
 * @date 2023/4/8 13:59
 */
@Data
public class FrontUserRegisterParams {

    @NotEmpty(message = "教师名称不能为空！", groups = TheFirstValidProperty.class)
    @Length(max = 10, message = "教师名称长度需小于等于10！", groups = TheSecondValidProperty.class)
    private String teacherName;

    @NotEmpty(message = "教师职级不能为空！", groups = TheFirstValidProperty.class)
    @Length(max = 10, message = "教师职级长度需小于等于10！", groups = TheSecondValidProperty.class)
    private String teacherRank;

    @NotEmpty(message = "用户名不能为空！", groups = TheFirstValidProperty.class)
    @Length(min = 8, message = "账号长度需大于等于8！", groups = TheSecondValidProperty.class)
    @Length(max = 16, message = "账号长度需小于等于16！", groups = TheSecondValidProperty.class)
    private String username;

    @NotEmpty(message = "密码不能为空！", groups = TheThirdValidProperty.class)
    @Length(min = 8, message = "密码长度需大于等于8！", groups = TheFourthValidProperty.class)
    @Length(max = 16, message = "密码长度需小于等于16！", groups = TheFourthValidProperty.class)
    private String password;
}