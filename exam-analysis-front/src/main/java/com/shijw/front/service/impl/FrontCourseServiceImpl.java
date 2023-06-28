package com.shijw.front.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.AtomicDouble;
import com.shijw.front.common.CommonPage;
import com.shijw.front.constant.CommonConstant;
import com.shijw.front.enums.FrontBusinessExceptionEnum;
import com.shijw.front.enums.FrontExceptionEnum;
import com.shijw.front.exception.FrontBusinessException;
import com.shijw.front.exception.FrontException;
import com.shijw.front.mapper.BackCourseMapper;
import com.shijw.front.mapper.FrontPersonalCourseMapper;
import com.shijw.front.mapper.FrontPersonalTeachInfoMapper;
import com.shijw.front.model.BackCourse;
import com.shijw.front.model.dto.CourseObjectiveDTO;
import com.shijw.front.model.dto.CourseObjectiveInfoDto;
import com.shijw.front.model.example.BackCourseExample;
import com.shijw.front.model.FrontPersonalCourse;
import com.shijw.front.model.example.FrontPersonalCourseExample;
import com.shijw.front.model.example.FrontPersonalTeachInfoExample;
import com.shijw.front.model.vo.QueryCourseVO;
import com.shijw.front.model.vo.QueryScoreHeaderVO;
import com.shijw.front.service.IFrontCourseService;
import com.shijw.front.service.ITokenService;
import com.shijw.front.single.SnowflakeIdSingleton;
import com.shijw.front.web.params.FrontCourseCreateParams;
import com.shijw.front.web.params.FrontCourseObjectivesCreateParams;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author SHI
 * @date 2023/4/12 21:27
 */
@Service
public class FrontCourseServiceImpl implements IFrontCourseService {

    @Autowired
    private BackCourseMapper backCourseMapper;
    @Autowired
    private FrontPersonalCourseMapper frontPersonalCourseMapper;
    @Autowired
    private ITokenService tokenService;
    @Autowired
    private FrontPersonalTeachInfoMapper frontPersonalTeachInfoMapper;


    @Override
    public CommonPage<QueryCourseVO> queryCurAllCourse(Integer pageSize, Integer pageNum) {

        List<QueryCourseVO> resList = new ArrayList<>();
        // 查询出 后台课程表 中所有课程
        List<BackCourse> backCourses = backCourseMapper.selectByExample(new BackCourseExample());
        // 查询出 前台个人课程表 中所有课程
        FrontPersonalCourseExample frontPersonalCourseExample = new FrontPersonalCourseExample();
        frontPersonalCourseExample.createCriteria().andCreateUsernameEqualTo(tokenService.getUsernameFromRequestHead());

        List<FrontPersonalCourse> personalCourses = frontPersonalCourseMapper.selectByExample(frontPersonalCourseExample);

        // 将结果汇总
        if (!CollectionUtils.isEmpty(backCourses)) {
            resList.addAll(backCourses.stream().map(BackCourse::toQueryCourseVo).collect(Collectors.toList()));
        }
        if (!CollectionUtils.isEmpty(personalCourses)) {
            resList.addAll(personalCourses.stream()
                    .peek(e -> e.setClassHour("讲课：" + e.getClassHourDto().getClazz() + " 上机：" + e.getClassHourDto().getComputer() + " 实验：" + e.getClassHourDto().getExperiment() + " 实践：" + e.getClassHourDto().getPractice()))
                    .map(FrontPersonalCourse::toQueryCourseVo)
                    .collect(Collectors.toList()));
        }

        // 重新设置结果集中的 id
        final int[] resIndex = {0};
        resList.forEach(e -> e.setId(++resIndex[0]));

        return CommonPage.restPage(resList);
    }

    @Override
    public void registerPersonalCourse(FrontCourseCreateParams params) {
        // 检查当前课程是否已存在于后台信息库
        BackCourseExample backCourseExample = new BackCourseExample();
        backCourseExample.createCriteria().andCourseNameEqualTo(params.getCourseName());
        List<BackCourse> sameCourse = backCourseMapper.selectByExample(backCourseExample);
        if (!CollectionUtils.isEmpty(sameCourse)) {
            throw new FrontBusinessException(FrontBusinessExceptionEnum.COURSE_NAME_EXIST_IN_BACKSTAGE_COURSE_DATABASE_EXCEPTION);
        }

        String operationUserName = tokenService.getUsernameFromRequestHead();

        // 检查当前课程是否在前台个人课程库中存在
        FrontPersonalCourseExample personalCourseExample = new FrontPersonalCourseExample();
        personalCourseExample.createCriteria()
                .andCourseNameEqualTo(params.getCourseName())
                .andCreateUsernameEqualTo(operationUserName);
        List<FrontPersonalCourse> samePersonalCourses = frontPersonalCourseMapper.selectByExample(personalCourseExample);
        if (!CollectionUtils.isEmpty(samePersonalCourses)) {
            throw new FrontBusinessException(FrontBusinessExceptionEnum.COURSE_NAME_EXIST_IN_PERSONAL_COURSE_DATABASE_EXCEPTION);
        }

        // 都不存在则可以插入当前用户个人课程库中
        FrontPersonalCourse personalCourse = new FrontPersonalCourse() {{
            setCourseId(CommonConstant.COURSE_ID_PREFIX + SnowflakeIdSingleton.getInstance().nextId());
            setCourseName(params.getCourseName());
            setCredits(params.getCredits());
            setCourseCode(params.getCourseCode());
            setCreateUsername(operationUserName);
            setProportion(params.getProportion());
            setClassHour(JSONObject.toJSONString(params.getClassHour()));
            setExamWay(params.getExamWay());
        }};
        int res = frontPersonalCourseMapper.insertSelective(personalCourse);
        if (res != 1) {
            throw new FrontException(FrontExceptionEnum.DATA_INSERT_ERROR);
        }
        if (!CollectionUtils.isEmpty(params.getCourseObjectives())) {
            createCourseObjectives(
                    FrontCourseObjectivesCreateParams.builder()
                            .courseId(personalCourse.getCourseId())
                            .objectiveDtos(params.getCourseObjectives())
                            .build());
        }
    }

    @Override
    @SneakyThrows
    public void createCourseObjectives(FrontCourseObjectivesCreateParams params) {
        // 验证所有的分数和是否为100
        AtomicDouble totalScore = new AtomicDouble();
        params.getObjectiveDtos().forEach(e -> {
            e.getScoreDtos().forEach(e1 -> {
                totalScore.addAndGet(e1.getScore());
            });
        });

        if (totalScore.get() != 100) {
            throw new FrontBusinessException(1000, "总分数不等于100 " + "(" + totalScore.get() + ")");
        }

        // 将 FrontCourseObjectivesCreate1Params.CourseObjectiveDto 转化为 {@link CourseObjectiveDTO1}
        List<CourseObjectiveDTO> collect = params.getObjectiveDtos()
                .stream()
                .map(FrontCourseObjectivesCreateParams.CourseObjectiveDto::toCourseObjectiveDTO)
                .collect(Collectors.toList());

        // 生成 CourseObjectiveInfo
        CourseObjectiveInfoDto courseObjectiveInfoDto = new CourseObjectiveInfoDto(new HashMap<String, CourseObjectiveInfoDto.ObjectiveInfoDto>() {{
            collect.forEach(e -> {
                e.getScoreDtos().forEach(scoreDto -> {
                    // 统计每个分数对象的分数和
                    if (!containsKey(scoreDto.getScoreName())) {
                        put(scoreDto.getScoreName(), new CourseObjectiveInfoDto.ObjectiveInfoDto(scoreDto.getScoreName(), scoreDto.getScore(), scoreDto.getScoreChineseName()));
                    } else {
                        CourseObjectiveInfoDto.ObjectiveInfoDto objectiveInfoDto = get(scoreDto.getScoreName());
                        objectiveInfoDto.setTotalScore(objectiveInfoDto.getTotalScore() + scoreDto.getScore());
                        put(scoreDto.getScoreName(), objectiveInfoDto);
                    }
                });
            });
        }});

        // 缓存每个分数的占比
        collect.forEach(e -> {
            e.getScoreDtos().forEach(e1 -> e1.setProportion(e1.getScore() / courseObjectiveInfoDto.getObjectiveInfoDtos().get(e1.getScoreName()).getTotalScore()));
        });

        // 拼接mysql 存储的json
        // 获取json形式的课程目标
        JSONArray courseObjective = new JSONArray();
        courseObjective.addAll(collect);

        // 获取json形式的课程目标信息
        JSONArray courseObjectiveInfo = new JSONArray();
        courseObjectiveInfo.addAll(courseObjectiveInfoDto.toList());

        frontPersonalCourseMapper.updateCourseObjectivesAndInfoByCourseId(params.getCourseId(), courseObjective.toJSONString(), courseObjectiveInfo.toJSONString());
    }

    @Override
    public List<QueryScoreHeaderVO> getCourseScoreShowHeader(String teachInfoId) {
        return new ArrayList<QueryScoreHeaderVO>() {{
            add(new QueryScoreHeaderVO("序号", "id"));
            add(new QueryScoreHeaderVO("学号", "studentId"));
            add(new QueryScoreHeaderVO("姓名", "studentName"));

            FrontPersonalTeachInfoExample frontPersonalTeachInfoExample = new FrontPersonalTeachInfoExample();
            frontPersonalTeachInfoExample.createCriteria().andTeachInfoIdEqualTo(teachInfoId);
            String courseId = frontPersonalTeachInfoMapper.selectByExample(frontPersonalTeachInfoExample).get(0).getCourseId();

            addAll(frontPersonalCourseMapper.selectByCourseId(courseId).getEnglishScoreNameObjectivesInfoMap().values()
                    .stream()
                    .map(dto -> new QueryScoreHeaderVO(dto.getScoreChineseName(), dto.getScoreName(), dto.getTotalScore(), true))
                    .sorted(Comparator.comparing(QueryScoreHeaderVO::getEnglishName))
                    .collect(Collectors.toList()));

            add(new QueryScoreHeaderVO("平时成绩", "usualScore", 100, true));
            add(new QueryScoreHeaderVO("期中成绩", "midTermScore", 100, true));
            add(new QueryScoreHeaderVO("期末成绩", "endTermScore", 100, true));
        }};
    }
}
