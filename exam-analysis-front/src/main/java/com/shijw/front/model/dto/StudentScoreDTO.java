package com.shijw.front.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

/**
 * @author SHI
 * @date 2023/5/19 0:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentScoreDTO {
    private String scoreName;
    private double score;
}
