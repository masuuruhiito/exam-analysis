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
public class BackUniversityRegisterParams extends BaseUniversityCodeParams {

    @NotEmpty(message = "学校名称不能为空！", groups = TheSecondValidProperty.class)
    private String universityName;

    @NotEmpty(message = "学校地址不能为空！", groups = TheThirdValidProperty.class)
    private String universityAddress;
}