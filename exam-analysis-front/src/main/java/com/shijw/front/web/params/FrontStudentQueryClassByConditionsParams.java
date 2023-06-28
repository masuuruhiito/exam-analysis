package com.shijw.front.web.params;

import lombok.Data;

/**
 * @author SHI
 * @date 2023/4/13 22:49
 */
@Data
public class FrontStudentQueryClassByConditionsParams {

    // 通过 学院、专业、年级、班级、是否绑定教授关系、数据来源、进行筛选
    private String collegeId;
    private String major;
    private Integer grade;
    private Integer classNumber;
    private String from;

    public FrontStudentQueryClassByConditionsParams() {
        from = "全部";
    }
}
