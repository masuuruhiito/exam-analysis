package com.shijw.front.model;

import com.shijw.front.constant.CommonConstant;
import com.shijw.front.model.vo.QueryCourseVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BackCourse {

    private Integer id;

    private String courseId;

    private String courseName;

    public static QueryCourseVO toQueryCourseVo(BackCourse backCourse) {
        QueryCourseVO res = new QueryCourseVO();
        BeanUtils.copyProperties(backCourse, res);
        res.setFrom(CommonConstant.INFO_FROM_BACKSTAGE);
        return res;
    }
}