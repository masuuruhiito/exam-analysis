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
public class BackUniversityQueryParams extends BaseUniversityCodeParams {

    private String universityName;
}