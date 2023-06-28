package com.shijw.back.web.params;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author SHI
 * @date 2023/4/8 13:59
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BackClassRegisterParams extends BaseUniversityCodeParams {

    @NotEmpty(message = "学院标识码不能为空！", groups = TheSecondValidProperty.class)
    private String collegeId;

    @NotEmpty(message = "注册班级专业不能为空！", groups = TheThirdValidProperty.class)
    private String major;

    @NotNull(message = "注册班级年级不能为空！", groups = TheFourthValidProperty.class)
    private Integer grade;

    @NotNull(message = "注册班级班号不能为空！", groups = TheFifthValidProperty.class)
    private Integer classNumber;
}