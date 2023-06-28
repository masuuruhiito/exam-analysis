package com.shijw.back.web.params;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * @author SHI
 * @date 2023/4/8 13:59
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BackCollegeRegisterParams extends BaseUniversityCodeParams {

    @NotEmpty(message = "学院名字不能为空！", groups = TheSecondValidProperty.class)
    private String collegeName;
}