package com.shijw.front.web.params;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * @author SHI
 * @date 2023/4/11 20:00
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode
public class FrontQueryTeachInfoParams {

    private String teacherId;

    private String courseId;

    private String classId;

    private String semester;
}
