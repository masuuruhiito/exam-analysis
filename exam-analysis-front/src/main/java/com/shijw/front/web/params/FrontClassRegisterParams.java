package com.shijw.front.web.params;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotEmpty;

/**
 * @author SHI
 * @date 2023/4/13 22:49
 */
@Data
public class FrontClassRegisterParams {

    @NotEmpty(message = "学院标识码不能为空！", groups = TheFirstValidProperty.class)
    private String collegeId;
    @NotEmpty(message = "专业不能为空！", groups = TheSecondValidProperty.class)
    private String major;
    @NotEmpty(message = "年级不能为空！", groups = TheThirdValidProperty.class)
    private Integer grade;
    @NotEmpty(message = "班级号不能为空！", groups = TheFourthValidProperty.class)
    private Integer classNumber;
}
