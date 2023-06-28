package com.shijw.front.model.vo;

import com.shijw.front.model.BackClass;
import com.shijw.front.model.BackTeacherClass;
import com.shijw.front.model.FrontPersonalClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author SHI
 * @date 2023/4/12 21:30
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class QueryTeachInfoVO {

    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String teachInfoId;

    private String teacherUsername;

    private String courseName;
    private String courseId;

    private String className;
    private String classId;

    private String semester;

    private Boolean isScoreUpload;
}
