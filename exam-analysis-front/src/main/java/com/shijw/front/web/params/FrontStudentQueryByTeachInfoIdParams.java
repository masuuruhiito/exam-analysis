package com.shijw.front.web.params;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author SHI
 * @date 2023/5/17 20:11
 */
@Data
public class FrontStudentQueryByTeachInfoIdParams {
    @NotEmpty(message = "教授信息标识码不能为空！", groups = TheFirstValidProperty.class)
    private String teachInfoId;
}
