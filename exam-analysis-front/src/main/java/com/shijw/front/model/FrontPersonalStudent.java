package com.shijw.front.model;

import com.shijw.front.model.vo.QueryStudentVO;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FrontPersonalStudent {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String studentId;

    private String universityCode;

    private String collegeId;

    private String classId;

    private String studentName;

    private String sex;

    private String birthday;

    private String phoneNumber;

    private String email;

    private String address;

    public static QueryStudentVO toQueryStudentVO(FrontPersonalStudent frontPersonalStudent) {
        QueryStudentVO res = new QueryStudentVO();
        BeanUtils.copyProperties(frontPersonalStudent, res);
        return res;
    }
}