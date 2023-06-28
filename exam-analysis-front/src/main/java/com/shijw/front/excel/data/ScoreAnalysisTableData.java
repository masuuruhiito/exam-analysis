package com.shijw.front.excel.data;

import com.shijw.front.mapper.*;
import com.shijw.front.model.*;
import com.shijw.front.model.dto.CourseClassScoreInfoDTO;
import com.shijw.front.model.example.FrontPersonalStudentExample;
import com.shijw.front.model.example.FrontUserExample;
import com.shijw.front.service.IFrontClassService;
import com.shijw.front.service.IFrontScoreAnalysisService;
import com.shijw.front.web.params.FrontCourseCreateParams;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author SHI
 * @date 2023/5/24 20:21
 */
@Component
public class ScoreAnalysisTableData implements IExcelData {

    private static final Pattern pattern = Pattern.compile("[0-9]+[.]{0,1}[0-9]*[dD]{0,1}");
    @Autowired
    @Lazy
    private IFrontScoreAnalysisService frontScoreAnalysisService;
    @Autowired
    private IFrontClassService frontClassService;
    @Autowired
    private FrontPersonalStudentMapper frontPersonalStudentMapper;
    @Autowired
    private FrontUserMapper frontUserMapper;

    @Override
    @SneakyThrows
    public List<List<Object>> getDataList(String teachInfoId) {
        CourseClassScoreInfoDTO infoDTO = frontScoreAnalysisService.getCourseClassScoreInfoDtoByTeachInfoId(teachInfoId);

        FrontPersonalCourse courseInfo = infoDTO.getCourseInfo();
        FrontPersonalTeachInfo teachInfo = infoDTO.getTeachInfo();
        FrontPersonalClass classInfo = infoDTO.getClassInfo();
        List<FrontPersonalScore> scoreBookList = infoDTO.getScoreBookList();

        FrontPersonalStudentExample frontPersonalStudentExample = new FrontPersonalStudentExample();
        frontPersonalStudentExample.createCriteria().andClassIdEqualTo(classInfo.getClassId());
        List<FrontPersonalStudent> students = frontPersonalStudentMapper.selectByExample(frontPersonalStudentExample);

        FrontUserExample frontUserExample = new FrontUserExample();
        frontUserExample.createCriteria().andUsernameEqualTo(teachInfo.getTeacherUsername());
        FrontUser teacherInfo = frontUserMapper.selectByExample(frontUserExample).get(0);

        FrontCourseCreateParams.ClassHourDto classHourDto = courseInfo.getClassHourDto();
        String classHour = "讲课：" + classHourDto.getClazz() + " 上机：" + classHourDto.getComputer() + " 实验：" + classHourDto.getExperiment() + " 实践：" + classHourDto.getPractice();

        return new ArrayList<List<Object>>() {{
            add(Arrays.asList("课程\n" + "名称", "课程\n" + "名称", courseInfo.getCourseName(), courseInfo.getCourseName(), "学期", teachInfo.getSemester(), teachInfo.getSemester(), "班级", frontClassService.getClassName(classInfo), frontClassService.getClassName(classInfo)));
            add(Arrays.asList("任课\n" + "教师", "任课\n" + "教师", teacherInfo.getTeacherName(), teacherInfo.getTeacherName(), "学生人数", scoreBookList.size(), scoreBookList.size(), "期末考\n" + "试方式", courseInfo.getExamWay(), courseInfo.getExamWay()));
            add(Arrays.asList("教师\n" + "职称", "教师\n" + "职称", teacherInfo.getTeacherRank(), teacherInfo.getTeacherRank(), "学时", classHour, classHour, classHour, classHour, classHour));
            add(new ArrayList<Object>() {{
                add("考核环节");
                add("考核环节");
                courseInfo.getChineseScoreNameObjectivesInfoMap()
                        .keySet()
                        .stream()
                        .sorted(String::compareTo)
                        .forEach(this::add);
                for (int i = 0; i < 6 - courseInfo.getChineseScoreNameObjectivesInfoMap().size(); i++) {
                    add("");
                }
                add("期末考试");
                add("合计");
            }});
            add(new ArrayList<Object>() {{
                add("占总成绩比例");
                add("占总成绩比例");

                int[] ints = Arrays.stream(courseInfo.getProportion().split("、")).mapToInt(Integer::parseInt).toArray();

                courseInfo.getChineseScoreNameObjectivesInfoMap()
                        .keySet()
                        .stream()
                        .sorted(String::compareTo)
                        .forEach(e -> {
                            add(courseInfo.getChineseScoreNameObjectivesInfoMap().get(e).getTotalScore() * ints[0] / 10);
                        });
                for (int i = 0; i < 6 - courseInfo.getChineseScoreNameObjectivesInfoMap().size(); i++) {
                    add("");
                }
                add(10 * ints[1]);
                add(100);
            }});

            // 缓存一份平均成绩（第七行）的合计
            final double[] totalScoreCache = {0};

            add(new ArrayList<Object>() {{
                add("平均成绩");
                add("平均成绩");

                int[] ints = Arrays.stream(courseInfo.getProportion().split("、")).mapToInt(Integer::parseInt).toArray();

                courseInfo.getChineseScoreNameObjectivesInfoMap()
                        .keySet()
                        .stream()
                        .sorted(String::compareTo)
                        .forEach(e -> {
                            add(String.format("%.2f", scoreBookList.stream()
                                    .mapToDouble(scoreDto -> scoreDto.getStudentScoreMap().get(courseInfo.getChineseScoreNameObjectivesInfoMap().get(e).getScoreName()) * ints[0] / 10)
                                    .average()
                                    .orElse(-1)));
                        });
                for (int i = 0; i < 6 - courseInfo.getChineseScoreNameObjectivesInfoMap().size(); i++) {
                    add("");
                }
                add(String.format("%.2f", scoreBookList.stream()
                        .mapToDouble(e -> e.getEndTermScore() * ints[1] / 10)
                        .average()
                        .orElse(-1)));

                AtomicReference<Double> sum = new AtomicReference<>((double) 0);
                forEach(e -> {
                    if (pattern.matcher(e.toString()).matches()) {
                        sum.updateAndGet(v -> v + Double.parseDouble(e.toString()));
                    }
                });
                add(String.format("%.2f", sum.get()));
                totalScoreCache[0] = sum.get();
            }});
            add(new ArrayList<Object>() {{
                add("达成度");
                add("达成度");

                int[] ints = Arrays.stream(courseInfo.getProportion().split("、")).mapToInt(Integer::parseInt).toArray();

                courseInfo.getChineseScoreNameObjectivesInfoMap()
                        .keySet()
                        .stream()
                        .sorted(String::compareTo)
                        .forEach(e -> {
                            add(String.format("%.2f", scoreBookList.stream()
                                    .mapToDouble(scoreDto -> scoreDto.getStudentScoreMap().get(courseInfo.getChineseScoreNameObjectivesInfoMap().get(e).getScoreName()) * ints[0] / 10)
                                    .average()
                                    .orElse(-1) / (courseInfo.getChineseScoreNameObjectivesInfoMap().get(e).getTotalScore() * ints[0] / 10)));
                        });
                for (int i = 0; i < 6 - courseInfo.getChineseScoreNameObjectivesInfoMap().size(); i++) {
                    add("");
                }
                add(String.format("%.2f", scoreBookList.stream()
                        .mapToDouble(e -> e.getEndTermScore() * ints[1] / 10)
                        .average()
                        .orElse(-1) / (100 * ints[1] / 10)));

                add(String.format("%.2f", totalScoreCache[0] / 100));
            }});
            add(new ArrayList<Object>() {{
                add("成\n" + "绩\n" + "分\n" + "析");
                add("试\n" + "卷\n" + "成\n" + "绩");
                add("最高分");
                add("最高分");
                add("最高分");
                add(String.format("%.2f", scoreBookList.stream().mapToDouble(FrontPersonalScore::getEndTermScore).max().getAsDouble()));
                add("最低分");
                add(String.format("%.2f", scoreBookList.stream().mapToDouble(FrontPersonalScore::getEndTermScore).min().getAsDouble()));
                add("平均分");
                add(String.format("%.2f", scoreBookList.stream().mapToDouble(FrontPersonalScore::getEndTermScore).average().orElse(-1)));
            }});
            add(new ArrayList<Object>() {{
                add("成\n" + "绩\n" + "分\n" + "析");
                add("试\n" + "卷\n" + "成\n" + "绩");
                add("分数");
                add("分数");
                add("分数");
                add("100-90");
                add("89-80");
                add("79-70");
                add("69-60");
                add("60分以下");
            }});
            add(new ArrayList<Object>() {{
                add("成\n" + "绩\n" + "分\n" + "析");
                add("试\n" + "卷\n" + "成\n" + "绩");
                add("人数");
                add("人数");
                add("人数");
                add(scoreBookList.stream().filter(e -> e.getEndTermScore() >= 90).count());
                add(scoreBookList.stream().filter(e -> e.getEndTermScore() >= 80 && e.getEndTermScore() < 90).count());
                add(scoreBookList.stream().filter(e -> e.getEndTermScore() >= 70 && e.getEndTermScore() < 80).count());
                add(scoreBookList.stream().filter(e -> e.getEndTermScore() >= 60 && e.getEndTermScore() < 70).count());
                add(scoreBookList.stream().filter(e -> e.getEndTermScore() < 60).count());
            }});
            add(new ArrayList<Object>() {{
                add("成\n" + "绩\n" + "分\n" + "析");
                add("试\n" + "卷\n" + "成\n" + "绩");
                add("百分比");
                add("百分比");
                add("百分比");
                add(String.format("%.2f", 100.0 * scoreBookList.stream().filter(e -> e.getEndTermScore() >= 90).count() / scoreBookList.size()));
                add(String.format("%.2f", 100.0 * scoreBookList.stream().filter(e -> e.getEndTermScore() >= 80 && e.getEndTermScore() < 90).count() / scoreBookList.size()));
                add(String.format("%.2f", 100.0 * scoreBookList.stream().filter(e -> e.getEndTermScore() >= 70 && e.getEndTermScore() < 80).count() / scoreBookList.size()));
                add(String.format("%.2f", 100.0 * scoreBookList.stream().filter(e -> e.getEndTermScore() >= 60 && e.getEndTermScore() < 70).count() / scoreBookList.size()));
                add(String.format("%.2f", 100.0 * scoreBookList.stream().filter(e -> e.getEndTermScore() < 60).count() / scoreBookList.size()));
            }});
            add(new ArrayList<Object>() {{
                add("成\n" + "绩\n" + "分\n" + "析");
                add("总\n" + "成\n" + "绩");
                add("最高分");
                add("最高分");
                add("最高分");

                int[] ints = Arrays.stream(courseInfo.getProportion().split("、")).mapToInt(Integer::parseInt).toArray();

                add(String.format("%.2f", scoreBookList.stream().mapToDouble(e -> (e.getUsualScore() * ints[0] / 10) + (e.getEndTermScore() * ints[1] / 10)).max().getAsDouble()));
                add("最低分");
                add(String.format("%.2f", scoreBookList.stream().mapToDouble(e -> (e.getUsualScore() * ints[0] / 10) + (e.getEndTermScore() * ints[1] / 10)).min().getAsDouble()));
                add("平均分");
                add(String.format("%.2f", scoreBookList.stream().mapToDouble(e -> (e.getUsualScore() * ints[0] / 10) + (e.getEndTermScore() * ints[1] / 10)).average().orElse(-1)));
            }});
            add(new ArrayList<Object>() {{
                add("成\n" + "绩\n" + "分\n" + "析");
                add("总\n" + "成\n" + "绩");
                add("分数");
                add("分数");
                add("分数");
                add("100-90");
                add("89-80");
                add("79-70");
                add("69-60");
                add("60分以下");
            }});
            add(new ArrayList<Object>() {{
                add("成\n" + "绩\n" + "分\n" + "析");
                add("总\n" + "成\n" + "绩");
                add("人数");
                add("人数");
                add("人数");

                int[] ints = Arrays.stream(courseInfo.getProportion().split("、")).mapToInt(Integer::parseInt).toArray();

                add(scoreBookList.stream().filter(e -> (e.getUsualScore() * ints[0] / 10) + (e.getEndTermScore() * ints[1] / 10) >= 90).count());
                add(scoreBookList.stream().filter(e -> (e.getUsualScore() * ints[0] / 10) + (e.getEndTermScore() * ints[1] / 10) >= 80 && (e.getUsualScore() * ints[0] / 10) + (e.getEndTermScore() * ints[1] / 10) < 90).count());
                add(scoreBookList.stream().filter(e -> (e.getUsualScore() * ints[0] / 10) + (e.getEndTermScore() * ints[1] / 10) >= 70 && (e.getUsualScore() * ints[0] / 10) + (e.getEndTermScore() * ints[1] / 10) < 80).count());
                add(scoreBookList.stream().filter(e -> (e.getUsualScore() * ints[0] / 10) + (e.getEndTermScore() * ints[1] / 10) >= 60 && (e.getUsualScore() * ints[0] / 10) + (e.getEndTermScore() * ints[1] / 10) < 70).count());
                add(scoreBookList.stream().filter(e -> (e.getUsualScore() * ints[0] / 10) + (e.getEndTermScore() * ints[1] / 10) < 60).count());
            }});
            add(new ArrayList<Object>() {{
                add("成\n" + "绩\n" + "分\n" + "析");
                add("总\n" + "成\n" + "绩");
                add("百分比");
                add("百分比");
                add("百分比");

                int[] ints = Arrays.stream(courseInfo.getProportion().split("、")).mapToInt(Integer::parseInt).toArray();

                add(String.format("%.2f", 100.0 * scoreBookList.stream().filter(e -> (e.getUsualScore() * ints[0] / 10) + (e.getEndTermScore() * ints[1] / 10) >= 90).count() / scoreBookList.size()));
                add(String.format("%.2f", 100.0 * scoreBookList.stream().filter(e -> (e.getUsualScore() * ints[0] / 10) + (e.getEndTermScore() * ints[1] / 10) >= 80 && (e.getUsualScore() * ints[0] / 10) + (e.getEndTermScore() * ints[1] / 10) < 90).count() / scoreBookList.size()));
                add(String.format("%.2f", 100.0 * scoreBookList.stream().filter(e -> (e.getUsualScore() * ints[0] / 10) + (e.getEndTermScore() * ints[1] / 10) >= 70 && (e.getUsualScore() * ints[0] / 10) + (e.getEndTermScore() * ints[1] / 10) < 80).count() / scoreBookList.size()));
                add(String.format("%.2f", 100.0 * scoreBookList.stream().filter(e -> (e.getUsualScore() * ints[0] / 10) + (e.getEndTermScore() * ints[1] / 10) >= 60 && (e.getUsualScore() * ints[0] / 10) + (e.getEndTermScore() * ints[1] / 10) < 70).count() / scoreBookList.size()));
                add(String.format("%.2f", 100.0 * scoreBookList.stream().filter(e -> (e.getUsualScore() * ints[0] / 10) + (e.getEndTermScore() * ints[1] / 10) < 60).count() / scoreBookList.size()));
            }});
            add(new ArrayList<Object>() {{
                add("各考核环节（除期末）内容及成绩分析");
                add("各考核环节（除期末）内容及成绩分析");
                for (int i = 0; i < 8; i++) {
                    add("");
                }
            }});
            add(new ArrayList<Object>() {{
                add("期末考核成绩分析");
                add("期末考核成绩分析");
                for (int i = 0; i < 8; i++) {
                    add("");
                }
            }});
        }};
    }
}
