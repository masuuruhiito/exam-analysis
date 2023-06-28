package com.shijw.front.web.params;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * @author SHI
 * @date 2023/4/15 12:10
 */
@Data
@AllArgsConstructor
public class FrontScoreAnalysisParams {
    @NotEmpty(message = "教学信息不能为空！", groups = TheFirstValidProperty.class)
    private String teachInfoId;

    private boolean addTargetPoint;

    /**
     * 前端传递参数是先调用无参构造器，后调用set方法进行赋值，所以可通过无参构造器进行设置默认值
     */
    public FrontScoreAnalysisParams() {
        addTargetPoint = false;
    }
}