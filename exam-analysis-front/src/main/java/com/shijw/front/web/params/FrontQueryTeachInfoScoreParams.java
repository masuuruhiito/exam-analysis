package com.shijw.front.web.params;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author SHI
 * @date 2023/4/13 22:49
 */
@Data
public class FrontQueryTeachInfoScoreParams {

    @NotEmpty(message = "教授信息不能为空！", groups = TheFirstValidProperty.class)
    private String teachInfoId;
}
