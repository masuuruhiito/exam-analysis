package com.shijw.front.model.dto;

import com.shijw.front.model.FrontPersonalClass;
import com.shijw.front.model.FrontPersonalCourse;
import com.shijw.front.model.FrontPersonalScore;
import com.shijw.front.model.FrontPersonalTeachInfo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/20 20:46
 */
@Data
@Builder
public class CourseClassScoreInfoDTO {
    private FrontPersonalClass classInfo;
    private FrontPersonalCourse courseInfo;
    private FrontPersonalTeachInfo teachInfo;
    private List<FrontPersonalScore> scoreBookList;
}
