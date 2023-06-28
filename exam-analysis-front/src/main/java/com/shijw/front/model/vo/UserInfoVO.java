package com.shijw.front.model.vo;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author SHI
 * @date 2023/5/10 14:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVO {
    private Date createTime;
    private String username;
    private String teacherName;
    private String teacherRank;
    private String collegeName;
    private boolean bindingTeacherIdentity;
}