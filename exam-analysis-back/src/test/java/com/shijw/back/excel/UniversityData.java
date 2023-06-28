package com.shijw.back.excel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author SHI
 * @date 2023/4/9 22:36
 */
@Getter
@Setter
@EqualsAndHashCode
public class UniversityData {
    String id;
    String name;
    String code;
    String department;
    String address;
    String level;
    String remark;
}
