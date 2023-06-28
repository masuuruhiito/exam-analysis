package com.shijw.front.excel.header;

import com.shijw.front.mapper.FrontPersonalCourseMapper;
import com.shijw.front.mapper.FrontPersonalTeachInfoMapper;
import com.shijw.front.model.dto.CourseObjectiveInfoDto;
import com.shijw.front.model.example.FrontPersonalTeachInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author SHI
 * @date 2023/5/20 23:57
 */
@Component
public class UploadScoreExcelTemplateHeader implements IExcelHeader {
    @Autowired
    private FrontPersonalTeachInfoMapper frontPersonalTeachInfoMapper;
    @Autowired
    private FrontPersonalCourseMapper frontPersonalCourseMapper;

    @Override
    public List<List<String>> getHeader(String teachInfoId) {
        FrontPersonalTeachInfoExample frontPersonalTeachInfoExample = new FrontPersonalTeachInfoExample();
        frontPersonalTeachInfoExample.createCriteria().andTeachInfoIdEqualTo(teachInfoId);
        String courseId = frontPersonalTeachInfoMapper.selectByExample(frontPersonalTeachInfoExample).get(0).getCourseId();
        Collection<CourseObjectiveInfoDto.ObjectiveInfoDto> infoDtos = frontPersonalCourseMapper.selectByCourseId(courseId).getEnglishScoreNameObjectivesInfoMap().values();

        return new ArrayList<List<String>>() {{
            add(Collections.singletonList("学号"));
            add(Collections.singletonList("学生姓名"));

            addAll(infoDtos.stream()
                    .map(e -> Collections.singletonList(e.getScoreChineseName()))
                    .sorted(Comparator.comparing(o -> o.get(0)))
                    .collect(Collectors.toList()));

            add(Collections.singletonList("平时成绩"));
            add(Collections.singletonList("期中成绩"));
            add(Collections.singletonList("期末成绩"));
        }};
    }
}
