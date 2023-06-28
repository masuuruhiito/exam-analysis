package com.shijw.front.model;

import com.shijw.front.constant.CommonConstant;
import com.shijw.front.model.vo.QueryClassVO;
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
public class FrontTeacherClass {
    private Integer id;

    private String teacherId;

    private String courseId;

    private String classId;

    private String semester;

    public static QueryClassVO toQueryClassVo(FrontTeacherClass frontTeacherClass) {
        QueryClassVO res = new QueryClassVO();
        BeanUtils.copyProperties(frontTeacherClass, res);
        res.setFrom(CommonConstant.INFO_FROM_BACKSTAGE);
        return res;
    }
}