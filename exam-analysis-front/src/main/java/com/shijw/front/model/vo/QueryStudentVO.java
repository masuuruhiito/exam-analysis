package com.shijw.front.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author SHI
 * @date 2023/5/16 22:09
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class QueryStudentVO {
    private Integer id;

    private String studentId;

    private String studentName;

    private String sex;

    private String birthday;

    private String phoneNumber;

    private String email;

    private String address;
}
