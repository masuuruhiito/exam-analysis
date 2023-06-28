package com.shijw.front.excel.data;

import com.shijw.front.mapper.FrontPersonalCourseMapper;
import com.shijw.front.mapper.FrontPersonalTeachInfoMapper;
import com.shijw.front.model.dto.CourseObjectiveInfoDto;
import com.shijw.front.model.example.FrontPersonalTeachInfoExample;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author SHI
 * @date 2023/4/23 19:42
 */
@Component
public class UploadScoreExcelTemplateData implements IExcelData {

    @Autowired
    private FrontPersonalTeachInfoMapper frontPersonalTeachInfoMapper;
    @Autowired
    private FrontPersonalCourseMapper frontPersonalCourseMapper;

    @Override
    @SneakyThrows
    public List<List<Object>> getDataList(String teachInfoId) {
        FrontPersonalTeachInfoExample frontPersonalTeachInfoExample = new FrontPersonalTeachInfoExample();
        frontPersonalTeachInfoExample.createCriteria().andTeachInfoIdEqualTo(teachInfoId);
        String courseId = frontPersonalTeachInfoMapper.selectByExample(frontPersonalTeachInfoExample).get(0).getCourseId();
        Collection<CourseObjectiveInfoDto.ObjectiveInfoDto> infoDtos = frontPersonalCourseMapper.selectByCourseId(courseId).getEnglishScoreNameObjectivesInfoMap().values();

        return new ArrayList<List<Object>>() {{
            add(new ArrayList<Object>() {{
                add("1904010501");
                add("张三（满分成绩）");
                infoDtos.forEach(e -> {
                    add(String.format("%.1f", e.getTotalScore()));
                });
                for (int i = 0; i < 3; i++) {
                    add(String.format("%d", 100));
                }
            }});
            add(new ArrayList<Object>() {{
                add("1904010502");
                add("李四");
                infoDtos.forEach(e -> {
                    add(String.format("%.1f", e.getTotalScore() * Math.random()));
                });
                for (int i = 0; i < 3; i++) {
                    add(String.format("%.1f", 100 * Math.random()));
                }
            }});
        }};
    }
}
