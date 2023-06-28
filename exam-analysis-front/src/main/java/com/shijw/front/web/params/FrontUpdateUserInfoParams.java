package com.shijw.front.web.params;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author SHI
 * @date 2023/5/25 16:43
 */
@Data
public class FrontUpdateUserInfoParams {
    @NotEmpty(message = "教师姓名码不能为空！", groups = TheFirstValidProperty.class)
    private String teacherName;
    @NotEmpty(message = "教师职级不能为空！", groups = TheSecondValidProperty.class)
    private String teacherRank;
    @NotEmpty(message = "学院不能为空！", groups = TheThirdValidProperty.class)
    private String collegeName;
}
