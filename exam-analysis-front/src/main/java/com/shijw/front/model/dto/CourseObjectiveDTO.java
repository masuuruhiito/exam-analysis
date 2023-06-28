package com.shijw.front.model.dto;

import com.shijw.front.web.params.FrontCourseObjectivesCreateParams;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseObjectiveDTO {

    private String name;

    private String targetPoint;

    private List<ScoreDto> scoreDtos;

    public void setScoreDtosByScoreParams(List<FrontCourseObjectivesCreateParams.CourseObjectiveDto.ScoreDto> scoreDtos) {
        this.scoreDtos = scoreDtos.stream()
                .map(ScoreDto::toScoreDto)
                .collect(Collectors.toList());
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ScoreDto {

        private String scoreName;
        /**
         * 当前指标点的总成绩
         */
        private double score;
        /**
         * 当前目标指标的分数与所有目标点的该指标点的占比
         */
        private double proportion;
        /**
         * 课程指标的中文名（自定义考核点的分数名和分数中文名相同）
         */
        private String scoreChineseName;

        public static ScoreDto toScoreDto(FrontCourseObjectivesCreateParams.CourseObjectiveDto.ScoreDto scoreParams) {
            ScoreDto res = new ScoreDto();
            BeanUtils.copyProperties(scoreParams, res);
            return res;
        }
    }
}