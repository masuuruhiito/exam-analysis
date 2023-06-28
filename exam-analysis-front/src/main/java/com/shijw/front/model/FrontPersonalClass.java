package com.shijw.front.model;

import com.shijw.front.model.vo.QueryClassVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanMap;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrontPersonalClass {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String classId;

    private String universityCode;

    private String collegeId;

    private String major;

    private Integer grade;

    private Integer classNumber;

    private String createUsername;

    public static QueryClassVO toQueryClassVO(FrontPersonalClass frontPersonalClass) {
        QueryClassVO res = new QueryClassVO();
        BeanUtils.copyProperties(frontPersonalClass, res);
        res.setCollege(frontPersonalClass.getCollegeId());
        return res;
    }
}