package com.shijw.front.excel.header;

import com.alibaba.fastjson.JSONArray;
import com.shijw.front.aop.annotation.ExcelHeaderInfo;
import com.shijw.front.excel.vo.ExportStudentScoreBookVO;
import com.shijw.front.model.FrontPersonalClass;
import com.shijw.front.model.FrontPersonalCourse;
import com.shijw.front.model.FrontPersonalScore;
import com.shijw.front.model.FrontPersonalTeachInfo;
import com.shijw.front.model.dto.CourseClassScoreInfoDTO;
import com.shijw.front.model.dto.CourseObjectiveDTO;
import com.shijw.front.model.dto.CourseObjectiveInfoDto;
import com.shijw.front.service.IFrontClassService;
import com.shijw.front.service.IFrontScoreAnalysisService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author SHI
 * @date 2023/4/20 19:59
 */
@Component
public class AchievementLevelCalculateTableHeader implements IExcelHeader {

    @Autowired
    @Lazy
    private IFrontScoreAnalysisService frontScoreAnalysisService;
    @Autowired
    private IFrontClassService frontClassService;


    @SneakyThrows
    @Override
    public List<List<String>> getHeader(String teachInfoId) {
        List<List<String>> header = new ArrayList<>();

        CourseClassScoreInfoDTO infoDTO = frontScoreAnalysisService.getCourseClassScoreInfoDtoByTeachInfoId(teachInfoId);

        FrontPersonalClass classInfo = infoDTO.getClassInfo();
        FrontPersonalCourse courseInfo = infoDTO.getCourseInfo();
        FrontPersonalTeachInfo teachInfo = infoDTO.getTeachInfo();

        List<CourseObjectiveDTO> courseObjectives = courseInfo.getObjectivesList();

        // 创建表头对象
        List<String> cellContain = new ArrayList<>();
        cellContain.add("哈尔滨理工大学课程目标、毕业要求达成度计算表");
        cellContain.add("专业");
        cellContain.add("课程名称");
        cellContain.add("序号");
        cellContain.add("序号");
        cellContain.add("序号");
        cellContain.add("序号");
        header.add(cellContain);

        cellContain = new ArrayList<>();
        cellContain.add("哈尔滨理工大学课程目标、毕业要求达成度计算表");
        cellContain.add(classInfo.getMajor());
        cellContain.add(courseInfo.getCourseName());
        cellContain.add("学号");
        cellContain.add("学号");
        cellContain.add("学号");
        cellContain.add("学号");
        header.add(cellContain);

        cellContain = new ArrayList<>();
        cellContain.add("哈尔滨理工大学课程目标、毕业要求达成度计算表");
        cellContain.add(classInfo.getMajor());
        cellContain.add(courseInfo.getCourseName());
        cellContain.add("学生姓名");
        cellContain.add("学生姓名");
        cellContain.add("学生姓名");
        cellContain.add("学生姓名");
        header.add(cellContain);

        int courseObjectiveIndex = 0;
        // 添加课程目标的表头数据
        for (CourseObjectiveDTO courseObjective : courseObjectives) {
            // 课程目标的
            int courseObjectiveFieldIndex = 0;
            for (CourseObjectiveDTO.ScoreDto scoreDto : courseObjective.getScoreDtos()) {

                cellContain = new ArrayList<>();
                cellContain.add("哈尔滨理工大学课程目标、毕业要求达成度计算表");

                if (courseObjectiveIndex == 0 && courseObjectiveFieldIndex++ == 0) {
                    cellContain.add("班级");
                    cellContain.add("课程编号");
                } else if (courseObjectiveIndex == 0 && courseObjectiveFieldIndex++ != 0) {
                    cellContain.add(frontClassService.getClassName(classInfo));
                    cellContain.add(courseInfo.getCourseCode() == null ? "" : courseInfo.getCourseCode());
                } else if (courseObjectiveIndex == 1 && courseObjectiveFieldIndex++ == 0) {
                    cellContain.add("学期");
                    cellContain.add("学分");
                } else if (courseObjectiveIndex == 1 && courseObjectiveFieldIndex++ != 0) {
                    cellContain.add(teachInfo.getSemester());
                    cellContain.add(String.valueOf(courseInfo.getCredits()));
                } else {
                    cellContain.add("");
                    cellContain.add("");
                }
                cellContain.add("毕业指标点" + courseObjective.getTargetPoint());
                cellContain.add(courseObjective.getName());
                cellContain.add(scoreDto.getScoreChineseName());
                cellContain.add(String.valueOf(scoreDto.getScore()));

                header.add(cellContain);
            }
            courseObjectiveIndex++;
        }

        // 添加平时、期末、总评成绩
        cellContain = new ArrayList<>();
        cellContain.add("哈尔滨理工大学课程目标、毕业要求达成度计算表");
        cellContain.add("");
        cellContain.add("");
        cellContain.add("平时成绩");
        cellContain.add("平时成绩");
        cellContain.add("平时成绩");
        cellContain.add("平时成绩");
        header.add(cellContain);

        cellContain = new ArrayList<>();
        cellContain.add("哈尔滨理工大学课程目标、毕业要求达成度计算表");
        cellContain.add("");
        cellContain.add("");
        cellContain.add("期末考试成绩");
        cellContain.add("期末考试成绩");
        cellContain.add("期末考试成绩");
        cellContain.add("期末考试成绩");
        header.add(cellContain);

        cellContain = new ArrayList<>();
        cellContain.add("哈尔滨理工大学课程目标、毕业要求达成度计算表");
        cellContain.add("");
        cellContain.add("");
        cellContain.add("总评成绩");
        cellContain.add("总评成绩");
        cellContain.add("总评成绩");
        cellContain.add("总评成绩");
        header.add(cellContain);


        // todo 对只有一个课程目标进行补偿，表头添加学期学分属性，长度于上一个保持一致
        if (courseObjectives.size() == 1) {

        }

        return header;
    }
}
