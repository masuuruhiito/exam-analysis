package com.shijw.front;

import com.shijw.front.service.IFrontCourseService;
import com.shijw.front.web.params.FrontCourseObjectivesCreateParams;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

/**
 * @author SHI
 * @date 2023/4/19 16:28
 */
@SpringBootTest
public class JSONTest {

    @Autowired
    private IFrontCourseService frontCourseService;

    @Test
    public void aaa() {
        FrontCourseObjectivesCreateParams build = FrontCourseObjectivesCreateParams.builder()
                .courseId("1095851792186474496")
                .objectiveDtos(new ArrayList<FrontCourseObjectivesCreateParams.CourseObjectiveDto>() {{
                    add(FrontCourseObjectivesCreateParams.CourseObjectiveDto.builder()
                            .name("课程目标一")
                            .targetPoint("1-4")
                            .build());

                    add(FrontCourseObjectivesCreateParams.CourseObjectiveDto.builder()
                            .name("课程目标二")
                            .targetPoint("3-1")
                            .build());

                }}).build();

        frontCourseService.createCourseObjectives(build);
    }
}