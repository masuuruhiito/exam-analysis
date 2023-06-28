package com.shijw.front.excel.header;

import com.shijw.front.model.FrontPersonalClass;
import com.shijw.front.model.FrontPersonalCourse;
import com.shijw.front.model.FrontPersonalTeachInfo;
import com.shijw.front.model.dto.CourseClassScoreInfoDTO;
import com.shijw.front.model.dto.CourseObjectiveDTO;
import com.shijw.front.service.IFrontClassService;
import com.shijw.front.service.IFrontScoreAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author SHI
 * @date 2023/5/23 18:20
 */
@Component
public class FinalExamQuestionsAndCourseContrastTableHeader implements IExcelHeader {

    @Override
    public List<List<String>> getHeader(String teachInfoId) {

        return new ArrayList<List<String>>() {{
            for (int i = 0; i < 6; i++) {
                add(Collections.singletonList("哈尔滨理工大学期末考试命题与课程目标对应表"));
            }
        }};
    }
}
