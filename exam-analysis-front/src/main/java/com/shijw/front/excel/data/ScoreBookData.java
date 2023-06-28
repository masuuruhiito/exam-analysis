package com.shijw.front.excel.data;

import com.shijw.front.mapper.FrontPersonalCourseMapper;
import com.shijw.front.mapper.FrontPersonalScoreMapper;
import com.shijw.front.mapper.FrontPersonalTeachInfoMapper;
import com.shijw.front.model.FrontPersonalScore;
import com.shijw.front.model.dto.CourseObjectiveInfoDto;
import com.shijw.front.model.example.FrontPersonalScoreExample;
import com.shijw.front.model.example.FrontPersonalTeachInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author SHI
 * @date 2023/5/23 13:10
 */
@Component
public class ScoreBookData implements IExcelData {

    @Autowired
    private FrontPersonalTeachInfoMapper frontPersonalTeachInfoMapper;
    @Autowired
    private FrontPersonalCourseMapper frontPersonalCourseMapper;
    @Autowired
    private FrontPersonalScoreMapper frontPersonalScoreMapper;


    @Override
    public List<List<Object>> getDataList(String teachInfoId) {
        FrontPersonalTeachInfoExample frontPersonalTeachInfoExample = new FrontPersonalTeachInfoExample();
        frontPersonalTeachInfoExample.createCriteria().andTeachInfoIdEqualTo(teachInfoId);
        String courseId = frontPersonalTeachInfoMapper.selectByExample(frontPersonalTeachInfoExample).get(0).getCourseId();
        Collection<CourseObjectiveInfoDto.ObjectiveInfoDto> infoDtos = frontPersonalCourseMapper.selectByCourseId(courseId).getEnglishScoreNameObjectivesInfoMap().values();

        FrontPersonalScoreExample frontPersonalScoreExample = new FrontPersonalScoreExample();
        frontPersonalScoreExample.createCriteria().andTeachInfoIdEqualTo(teachInfoId);
        List<FrontPersonalScore> scores = frontPersonalScoreMapper.selectByExample(frontPersonalScoreExample);

        return new ArrayList<List<Object>>() {{
            for (FrontPersonalScore score : scores) {
                add(new ArrayList<Object>() {{
                    add(score.getStudentId());
                    add(score.getStudentName());

                    Map<String, Double> studentScoreMap = score.getStudentScoreMap();

                    infoDtos.stream()
                            .sorted(Comparator.comparing(CourseObjectiveInfoDto.ObjectiveInfoDto::getScoreChineseName))
                            .forEach(e -> {
                                add(String.format("%.1f", studentScoreMap.get(e.getScoreName())));
                            });

                    add(score.getUsualScore());
                    add(score.getMidTermScore());
                    add(score.getEndTermScore());
                }});
            }
        }};
    }
}
