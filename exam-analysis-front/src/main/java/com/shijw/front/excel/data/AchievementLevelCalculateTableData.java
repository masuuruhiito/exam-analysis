package com.shijw.front.excel.data;

import com.alibaba.fastjson.JSONArray;
import com.shijw.front.aop.annotation.ExcelHeaderInfo;
import com.shijw.front.model.FrontPersonalCourse;
import com.shijw.front.model.FrontPersonalScore;
import com.shijw.front.model.dto.CourseClassScoreInfoDTO;
import com.shijw.front.model.dto.CourseObjectiveDTO;
import com.shijw.front.model.dto.StudentScoreDTO;
import com.shijw.front.service.IFrontScoreAnalysisService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author SHI
 * @date 2023/4/23 19:42
 */
@Component
public class AchievementLevelCalculateTableData implements IExcelData {

    @Autowired
    @Lazy
    private IFrontScoreAnalysisService frontScoreAnalysisService;

    @Override
    @SneakyThrows
    public List<List<Object>> getDataList(String teachInfoId) {
        CourseClassScoreInfoDTO infoDTO = frontScoreAnalysisService.getCourseClassScoreInfoDtoByTeachInfoId(teachInfoId);

        FrontPersonalCourse courseInfo = infoDTO.getCourseInfo();
        List<FrontPersonalScore> scoreList = infoDTO.getScoreBookList();

        List<CourseObjectiveDTO> courseObjectives = courseInfo.getObjectivesList();

        List<List<Object>> res = new ArrayList<>();

        int index = 1;
        for (FrontPersonalScore scoreDTO : scoreList) {
            List<Object> line = new ArrayList<>();
            // 设置 序号、学号、姓名
            line.add(index++);
            line.add(scoreDTO.getStudentId());
            line.add(scoreDTO.getStudentName());

            // 先获取学生成绩的map
            Map<String, Double> studentScoreMap = scoreDTO.getStudentScoreMap();

            // 通过课程目标的解析，知道这一行是做什么的
            courseObjectives.forEach(e -> {
                e.getScoreDtos().forEach(e1 -> {
                    double score = studentScoreMap.getOrDefault(e1.getScoreName(), 0.0);
                    line.add(String.format("%.1f", e1.getProportion() * score));
                });
            });

            line.add(scoreDTO.getUsualScore());
            line.add(scoreDTO.getEndTermScore());

            // 总评成的比例由老师输入
            String proportion = courseInfo.getProportion();
            int[] ints = Arrays.stream(proportion.split("、")).mapToInt(Integer::parseInt).toArray();
            line.add(scoreDTO.getUsualScore() * ints[0] / 10 + scoreDTO.getEndTermScore() * ints[1] / 10);
            res.add(line);
        }
//          todo
//        res.add(new ArrayList<Object>() {{
//            add("注：此表一式二份，一份随试卷存档，一份由任课教师所在学院统一保管。");
//        }});

        return res;
    }
}
