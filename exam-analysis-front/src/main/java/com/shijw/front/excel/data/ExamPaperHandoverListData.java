package com.shijw.front.excel.data;

import com.shijw.front.model.FrontPersonalClass;
import com.shijw.front.model.FrontPersonalCourse;
import com.shijw.front.model.FrontPersonalTeachInfo;
import com.shijw.front.model.dto.CourseClassScoreInfoDTO;
import com.shijw.front.service.IFrontClassService;
import com.shijw.front.service.IFrontScoreAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author SHI
 * @date 2023/5/21 15:19
 */
@Component
public class ExamPaperHandoverListData implements IExcelData {

    @Autowired
    @Lazy
    private IFrontScoreAnalysisService frontScoreAnalysisService;
    @Autowired
    private IFrontClassService frontClassService;

    @Override
    public List<List<Object>> getDataList(String teachInfoId) {
        CourseClassScoreInfoDTO infoDTO = frontScoreAnalysisService.getCourseClassScoreInfoDtoByTeachInfoId(teachInfoId);

        FrontPersonalCourse courseInfo = infoDTO.getCourseInfo();
        FrontPersonalTeachInfo teachInfo = infoDTO.getTeachInfo();
        FrontPersonalClass classInfo = infoDTO.getClassInfo();

        List<List<Object>> res = new ArrayList<>();

        // 设置第一行：课程名称
        res.add(new ArrayList<Object>() {{
            add("课程名称");
            add(courseInfo.getCourseName());
            add(courseInfo.getCourseName());
            add(courseInfo.getCourseName());
            add(courseInfo.getCourseName());
        }});

        // 设置第二行：学期、班级
        res.add(new ArrayList<Object>() {{
            add("学期");
            add(teachInfo.getSemester());
            add("班级");
            add(frontClassService.getClassName(classInfo));
            add(frontClassService.getClassName(classInfo));
        }});

        // 设置目录
        res.add(new ArrayList<Object>() {{
            add("序号");
            add("交接内容");
            add("交接内容");
            add("交接内容");
            add("标记");
        }});

        // 添加要导出的目录
        res.add(new ArrayList<Object>() {{
            add("1");
            add("记分册");
            add("记分册");
            add("记分册");
            add("1");
        }});
        res.add(new ArrayList<Object>() {{
            add("2");
            add("成绩单");
            add("成绩单");
            add("成绩单");
            add("1");
        }});
        res.add(new ArrayList<Object>() {{
            add("3");
            add("监考记事");
            add("监考记事");
            add("监考记事");
            add("1");
        }});
        res.add(new ArrayList<Object>() {{
            add("4");
            add("期末考试命题与课程目标对应表（参加工程教育认证各专业的相关课程须填写）");
            add("期末考试命题与课程目标对应表（参加工程教育认证各专业的相关课程须填写）");
            add("期末考试命题与课程目标对应表（参加工程教育认证各专业的相关课程须填写）");
            add("1");
        }});
        res.add(new ArrayList<Object>() {{
            add("5");
            add("课程目标、毕业要求达成度计算表-1");
            add("课程目标、毕业要求达成度计算表-1");
            add("课程目标、毕业要求达成度计算表-1");
            add("1");
        }});
        res.add(new ArrayList<Object>() {{
            add("6");
            add("课程目标、毕业要求达成度计算表-2");
            add("课程目标、毕业要求达成度计算表-2");
            add("课程目标、毕业要求达成度计算表-2");
            add("1");
        }});
        res.add(new ArrayList<Object>() {{
            add("7");
            add("课程对毕业要求达成度评价表");
            add("课程对毕业要求达成度评价表");
            add("课程对毕业要求达成度评价表");
            add("1");
        }});
        res.add(new ArrayList<Object>() {{
            add("8");
            add("成绩分析表");
            add("成绩分析表");
            add("成绩分析表");
            add("1");
        }});
        res.add(new ArrayList<Object>() {{
            add("9");
            add("试卷");
            add("试卷");
            add("试卷");
            add("1");
        }});
        for (int i = 10; i <= 15; i++) {
            int finalI = i;
            res.add(new ArrayList<Object>() {{
                add(finalI);
                add("");
                add("");
                add("");
                add("");
            }});
        }

        // 添加任课教师、教学秘书签字
        res.add(new ArrayList<Object>() {{
            add("任课教师签字：\n\n\n" + "                    年  月  日");
            add("任课教师签字：\n\n\n" + "                    年  月  日");
            add("教学秘书签字：\n\n\n" + "                                   年  月  日");
            add("教学秘书签字：\n\n\n" + "                                   年  月  日");
            add("教学秘书签字：\n\n\n" + "                                   年  月  日");
        }});

        // 添加备注
        res.add(new ArrayList<Object>() {{
            add("注：每册试卷存档由任课教师打印此交接单一式二份，一份任课教师留存，一份随试卷存档。");
            add("注：每册试卷存档由任课教师打印此交接单一式二份，一份任课教师留存，一份随试卷存档。");
            add("注：每册试卷存档由任课教师打印此交接单一式二份，一份任课教师留存，一份随试卷存档。");
            add("注：每册试卷存档由任课教师打印此交接单一式二份，一份任课教师留存，一份随试卷存档。");
            add("注：每册试卷存档由任课教师打印此交接单一式二份，一份任课教师留存，一份随试卷存档。");
        }});

        return res;
    }
}
