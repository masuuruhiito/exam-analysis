package com.shijw.front.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author SHI
 * @date 2023/5/17 15:44
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class QueryScoreVO {

    private Integer id;

    private String studentId;

    private String studentName;

    private Double homeworkScore;

    private Double experimentScore;

    private Double practiceScore;

    private Double caseScore;

    private Double performanceScore;

    private Double processEvaluationScore;

    private Double usualScore;

    private Double midTermScore;

    private Double endTermScore;
}
