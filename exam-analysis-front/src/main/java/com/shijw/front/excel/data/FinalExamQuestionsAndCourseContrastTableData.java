package com.shijw.front.excel.data;

import com.shijw.front.excel.header.IExcelHeader;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author SHI
 * @date 2023/5/23 18:13
 */
@Component
public class FinalExamQuestionsAndCourseContrastTableData implements IExcelData {

    @Autowired
    @Lazy
    private IFrontScoreAnalysisService frontScoreAnalysisService;
    @Autowired
    private IFrontClassService frontClassService;

    @Override
    public List<List<Object>> getDataList(String teachInfoId) {
        CourseClassScoreInfoDTO infoDTO = frontScoreAnalysisService.getCourseClassScoreInfoDtoByTeachInfoId(teachInfoId);

        FrontPersonalClass classInfo = infoDTO.getClassInfo();
        FrontPersonalCourse courseInfo = infoDTO.getCourseInfo();
        FrontPersonalTeachInfo teachInfo = infoDTO.getTeachInfo();
        List<CourseObjectiveDTO> objectivesList = courseInfo.getObjectivesList();

        return new ArrayList<List<Object>>() {{
            add(Arrays.asList("学期", teachInfo.getSemester(), "课程名称", courseInfo.getCourseName(), "上课班级", frontClassService.getClassName(classInfo)));
            add(new ArrayList<Object>() {{
                add("题型");
                add("试题编号及简要描述");
                for (CourseObjectiveDTO objectiveDTO : objectivesList) {
                    add(objectiveDTO.getName());
                }
                for (int i = 0; i < 4 - objectivesList.size(); i++) {
                    add("");
                }
            }});
            for (int i = 0; i < 7; i++) {
                add(Arrays.asList(null, null, null, null, null, null));
            }
            add(Arrays.asList("分值合并", "分值合并", "", "", "", ""));
            add(Arrays.asList("注：1、本表随期末试卷一同存档；", "注：1、本表随期末试卷一同存档；", "注：1、本表随期末试卷一同存档；", "注：1、本表随期末试卷一同存档；", "注：1、本表随期末试卷一同存档；", "注：1、本表随期末试卷一同存档；"));
            add(Arrays.asList("命题小组成员：", "命题小组成员：", "命题小组成员：", "命题小组成员：", "命题小组成员：", "命题小组成员："));
            add(Arrays.asList("", "", "", "", "系主任：", "系主任："));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            add(Arrays.asList("", "", "", "", "日期：" + dateFormat.format(new Date()), "日期：" + dateFormat.format(new Date())));
        }};
    }
}
