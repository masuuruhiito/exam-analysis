package com.shijw.front.model;

import com.shijw.front.model.vo.QueryTeachInfoVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FrontPersonalTeachInfo {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String teachInfoId;

    private String teacherId;

    private String teacherUsername;

    private String courseId;

    private String classId;

    private String semester;

    private Boolean isScoreUpload;

    public static QueryTeachInfoVO toQueryTeachInfoVO(FrontPersonalTeachInfo frontPersonalTeachInfo) {
        QueryTeachInfoVO res = new QueryTeachInfoVO();
        BeanUtils.copyProperties(frontPersonalTeachInfo, res);
        return res;
    }
}