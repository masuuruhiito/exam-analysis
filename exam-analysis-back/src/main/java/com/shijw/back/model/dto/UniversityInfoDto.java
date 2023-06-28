package com.shijw.back.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author SHI
 * @date 2023/4/9 22:47
 */
@Data
@AllArgsConstructor
public class UniversityInfoDto {

    /**
     * 学校名称
     */
    private String name;

    /**
     * 学校唯一标识码
     */
    private String code;
}
