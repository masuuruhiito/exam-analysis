package com.shijw.front.service.impl;

import com.shijw.front.service.IFrontCourseService;
import com.shijw.front.web.params.FrontCourseObjectivesCreateParams;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

/**
 * @author SHI
 * @date 2023/5/18 16:22
 */
@SpringBootTest
class FrontCourseServiceImplTest {

    @Autowired
    private IFrontCourseService frontCourseService;

    @Test
    void createCourseObjectives1() {
        FrontCourseObjectivesCreateParams params = FrontCourseObjectivesCreateParams.builder().build();
        params.setCourseId("COU_1106256389300289536");

        params.setObjectiveDtos(new ArrayList<FrontCourseObjectivesCreateParams.CourseObjectiveDto>() {{
            add(FrontCourseObjectivesCreateParams.CourseObjectiveDto.builder()
                    .name("课程目标1")
                    .targetPoint("1-4")
                    .scoreDtos(new ArrayList<FrontCourseObjectivesCreateParams.CourseObjectiveDto.ScoreDto>() {{
                        add(new FrontCourseObjectivesCreateParams.CourseObjectiveDto.ScoreDto("homeworkScore", 5, "作业"));
                        add(new FrontCourseObjectivesCreateParams.CourseObjectiveDto.ScoreDto("experimentScore", 8, "实验"));
                        add(new FrontCourseObjectivesCreateParams.CourseObjectiveDto.ScoreDto("performanceScore", 4, "课堂表现"));
                        add(new FrontCourseObjectivesCreateParams.CourseObjectiveDto.ScoreDto("practiceScore", 8, "实践"));
                        add(new FrontCourseObjectivesCreateParams.CourseObjectiveDto.ScoreDto("processEvaluationScore", 10, "过程考核"));
                        add(new FrontCourseObjectivesCreateParams.CourseObjectiveDto.ScoreDto("caseScore", 5, "案例"));
                    }})
                    .build());
            add(FrontCourseObjectivesCreateParams.CourseObjectiveDto.builder()
                    .name("课程目标2")
                    .targetPoint("3-1")
                    .scoreDtos(new ArrayList<FrontCourseObjectivesCreateParams.CourseObjectiveDto.ScoreDto>() {{
                        add(new FrontCourseObjectivesCreateParams.CourseObjectiveDto.ScoreDto("homeworkScore", 10, "作业"));
                        add(new FrontCourseObjectivesCreateParams.CourseObjectiveDto.ScoreDto("experimentScore", 12, "实验"));
                        add(new FrontCourseObjectivesCreateParams.CourseObjectiveDto.ScoreDto("performanceScore", 6, "课堂表现"));
                        add(new FrontCourseObjectivesCreateParams.CourseObjectiveDto.ScoreDto("practiceScore", 12, "实践"));
                        add(new FrontCourseObjectivesCreateParams.CourseObjectiveDto.ScoreDto("processEvaluationScore", 15, "过程考核"));
                        add(new FrontCourseObjectivesCreateParams.CourseObjectiveDto.ScoreDto("caseScore", 5, "案例"));
                    }})
                    .build());
        }});

        frontCourseService.createCourseObjectives(params);
    }

}