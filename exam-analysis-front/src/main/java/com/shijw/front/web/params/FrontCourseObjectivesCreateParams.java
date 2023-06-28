package com.shijw.front.web.params;

import com.shijw.front.model.dto.CourseObjectiveDTO;
import lombok.*;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/19 16:17
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FrontCourseObjectivesCreateParams {

    private String courseId;
    private List<CourseObjectiveDto> objectiveDtos;

    @Data
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CourseObjectiveDto {

        private String name;
        private String targetPoint;
        private List<CourseObjectiveDto.ScoreDto> scoreDtos;


        /**
         * 课程目标dto1
         *
         * @param courseObjective 课程目标
         * @return {@link CourseObjectiveDto}
         */
        @SneakyThrows
        public static CourseObjectiveDTO toCourseObjectiveDTO(CourseObjectiveDto courseObjective) {
            CourseObjectiveDTO courseObjectiveDTO = new CourseObjectiveDTO();
            courseObjectiveDTO.setName(courseObjective.getName());
            courseObjectiveDTO.setTargetPoint(courseObjective.getTargetPoint());
            courseObjectiveDTO.setScoreDtosByScoreParams(courseObjective.getScoreDtos());
            return courseObjectiveDTO;
        }

        @Data
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class ScoreDto {
            private String scoreName;
            private double score;
            private String scoreChineseName;
        }
    }
}