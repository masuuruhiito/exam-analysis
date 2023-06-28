package com.shijw.back.web.params;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

/**
 * @author SHI
 * @date 2023/4/10 21:36
 */
@Getter
public class BaseUniversityCodeParams {
    @NotEmpty(message = "学校标识码不能为空！", groups = TheFirstValidProperty.class)
    private String universityCode;
}