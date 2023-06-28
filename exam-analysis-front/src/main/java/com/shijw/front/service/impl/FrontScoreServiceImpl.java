package com.shijw.front.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.AbstractColumnWidthStyleStrategy;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shijw.front.enums.FrontExceptionEnum;
import com.shijw.front.excel.data.UploadScoreExcelTemplateData;
import com.shijw.front.excel.header.UploadScoreExcelTemplateHeader;
import com.shijw.front.exception.FrontBusinessException;
import com.shijw.front.exception.FrontException;
import com.shijw.front.mapper.FrontPersonalCourseMapper;
import com.shijw.front.mapper.FrontPersonalScoreMapper;
import com.shijw.front.excel.vo.UploadStudentScoreDataDTO;
import com.shijw.front.mapper.FrontPersonalStudentMapper;
import com.shijw.front.mapper.FrontPersonalTeachInfoMapper;
import com.shijw.front.model.FrontPersonalCourse;
import com.shijw.front.model.FrontPersonalScore;
import com.shijw.front.model.FrontPersonalStudent;
import com.shijw.front.model.FrontPersonalTeachInfo;
import com.shijw.front.model.dto.CourseObjectiveInfoDto;
import com.shijw.front.model.dto.StudentScoreDTO;
import com.shijw.front.model.example.FrontPersonalScoreExample;
import com.shijw.front.model.example.FrontPersonalStudentExample;
import com.shijw.front.model.example.FrontPersonalTeachInfoExample;
import com.shijw.front.service.IFrontScoreAnalysisService;
import com.shijw.front.service.IFrontScoreService;
import com.shijw.front.utils.CalculateUtils;
import com.shijw.front.utils.ExcelUtils;
import com.shijw.front.web.params.FrontAddStudentScoreParams;
import com.shijw.front.web.params.FrontDeleteStudentScoreParams;
import com.shijw.front.web.params.FrontQueryTeachInfoScoreParams;
import com.shijw.front.web.params.FrontScoreUploadScoreByExcelParams;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author SHI
 * @date 2023/4/14 22:07
 */
@Service
public class FrontScoreServiceImpl implements IFrontScoreService {

    @Autowired
    private FrontPersonalScoreMapper frontPersonalScoreMapper;
    @Autowired
    private FrontPersonalStudentMapper frontPersonalStudentMapper;
    @Autowired
    private FrontPersonalTeachInfoMapper frontPersonalTeachInfoMapper;
    @Autowired
    private IFrontScoreAnalysisService frontScoreAnalysisService;
    @Autowired
    private FrontPersonalCourseMapper frontPersonalCourseMapper;
    @Autowired
    private UploadScoreExcelTemplateHeader uploadScoreExcelTemplateHeader;
    @Autowired
    private UploadScoreExcelTemplateData uploadScoreExcelTemplateData;

    @Override
    @SneakyThrows
    public void uploadScoreByExcel(FrontScoreUploadScoreByExcelParams params) {
        MultipartFile studentScoreExcel = params.getStudentScoreExcel();

        // 校验学生名单、班级、学科、课程目标 是否正确
        FrontPersonalCourse courseInfo = frontScoreAnalysisService.getCourseClassScoreInfoDtoByTeachInfoId(params.getTeachInfoId()).getCourseInfo();
        String classId = frontScoreAnalysisService.getCourseClassScoreInfoDtoByTeachInfoId(params.getTeachInfoId()).getClassInfo().getClassId();

        // 校验成绩是否上传过
        FrontPersonalScoreExample frontPersonalScoreExample = new FrontPersonalScoreExample();
        frontPersonalScoreExample.createCriteria().andTeachInfoIdEqualTo(params.getTeachInfoId());
        if (!CollectionUtils.isEmpty(frontPersonalScoreMapper.selectByExample(frontPersonalScoreExample))) {
            throw new FrontBusinessException(400, "该班级该课程已经存在成绩，请检查后再批量上传！");
        }

        // 获取输入的成绩
        List<Map<String, Object>> inputScores = ExcelUtils.readExcelToMap(studentScoreExcel.getInputStream(), "0");
        if (CollectionUtils.isEmpty(inputScores)) {
            throw new FrontBusinessException(400, "上传成绩Excel中数据为空，请检查后重新上传");
        }

        Map<String, CourseObjectiveInfoDto.ObjectiveInfoDto> objectiveInfoMap = courseInfo.getChineseScoreNameObjectivesInfoMap();
        List<List<String>> header = uploadScoreExcelTemplateHeader.getHeader(params.getTeachInfoId());
        // 校验表头是否相同
        if (!header.stream().map(e -> e.get(0)).collect(Collectors.toSet()).equals(inputScores.get(0).keySet())) {
            throw new FrontBusinessException(400, "上传Excel格式与模板不符，请检查后重新上传！");
        }
        // 校验成绩是否小于最大值
        // 校验学号是否存在
        inputScores.forEach(line -> {
            line.forEach((scoreName, score) -> {
                if (!"学号".equals(scoreName) && !"学生姓名".equals(scoreName)) {
                    if ("平时成绩".equals(scoreName) || "期中成绩".equals(scoreName) || "期末成绩".equals(scoreName)) {
                        if (CalculateUtils.getDoubleFromObjectWithDefault(score) > 100) {
                            throw new FrontBusinessException(400, "学生" + line.get("学生姓名") + "的" + scoreName + "分数" + score + "超过课程目标设置最大值" + objectiveInfoMap.get(scoreName).getTotalScore() + ",请检查后重试！");
                        }
                    } else if (CalculateUtils.getDoubleFromObjectWithDefault(score) > objectiveInfoMap.get(scoreName).getTotalScore()) {
                        throw new FrontBusinessException(400, "学生" + line.get("学生姓名") + "的" + scoreName + "分数" + score + "超过课程目标设置最大值" + objectiveInfoMap.get(scoreName).getTotalScore() + ",请检查后重试！");
                    }
                } else if ("学号".equals(scoreName)) {
                    FrontPersonalStudentExample frontPersonalStudentExample = new FrontPersonalStudentExample();
                    frontPersonalStudentExample.createCriteria().andClassIdEqualTo(classId).andStudentIdEqualTo(String.valueOf(score));
                    List<FrontPersonalStudent> student = frontPersonalStudentMapper.selectByExample(frontPersonalStudentExample);
                    if (CollectionUtils.isEmpty(student)) {
                        throw new FrontBusinessException(400, "该班级不存在学号为" + score + "的学生，请检查后重试！");
                    }
                }
            });
        });

        // 循环插入数据
        for (Map<String, Object> line : inputScores) {
            FrontAddStudentScoreParams addStudentScoreParams = FrontAddStudentScoreParams.builder()
                    .teachInfoId(params.getTeachInfoId())
                    .studentId(String.valueOf(line.get("学号")))
                    .usualScore(CalculateUtils.getDoubleFromObjectWithDefault(line.get("平时成绩")))
                    .midTermScore(CalculateUtils.getDoubleFromObjectWithDefault(line.get("期中成绩")))
                    .endTermScore(CalculateUtils.getDoubleFromObjectWithDefault(line.get("期末成绩")))
                    .scoreList(new ArrayList<StudentScoreDTO>() {{
                        objectiveInfoMap.forEach((chineseName, objectiveInfoDto) -> {
                            add(new StudentScoreDTO(objectiveInfoDto.getScoreName(), CalculateUtils.getDoubleFromObjectWithDefault(line.get(chineseName))));
                        });
                    }})
                    .build();

            addStudentScores(addStudentScoreParams);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addStudentScores(FrontAddStudentScoreParams params) {
        // 校验 teachInfoId
        FrontPersonalTeachInfoExample frontPersonalTeachInfoExample = new FrontPersonalTeachInfoExample();
        frontPersonalTeachInfoExample.createCriteria().andTeachInfoIdEqualTo(params.getTeachInfoId());
        List<FrontPersonalTeachInfo> frontPersonalTeachInfos = frontPersonalTeachInfoMapper.selectByExample(frontPersonalTeachInfoExample);
        if (CollectionUtils.isEmpty(frontPersonalTeachInfos)) {
            throw new FrontBusinessException(1003, "教授关系标识码错误，不能插入成绩");
        }

        // 校验 studentId
        FrontPersonalStudentExample frontPersonalStudentExample = new FrontPersonalStudentExample();
        frontPersonalStudentExample.createCriteria().andStudentIdEqualTo(params.getStudentId());
        List<FrontPersonalStudent> frontPersonalStudents = frontPersonalStudentMapper.selectByExample(frontPersonalStudentExample);
        if (CollectionUtils.isEmpty(frontPersonalStudents)) {
            throw new FrontBusinessException(1003, "学生ID错误，不能插入成绩");
        }

        FrontPersonalScore frontScore = new FrontPersonalScore();
        BeanUtils.copyProperties(params, frontScore);
        frontScore.setStudentName(frontPersonalStudents.get(0).getStudentName());

        JSONArray scoreListJson = new JSONArray();
        scoreListJson.addAll(params.getScoreList());

        frontScore.setScoreList(scoreListJson.toJSONString());
        frontPersonalScoreMapper.insertSelective(frontScore);

        // 设置教授关系是否上传成绩为true
        if (!frontPersonalTeachInfos.get(0).getIsScoreUpload()) {
            frontPersonalTeachInfos.get(0).setIsScoreUpload(true);
            frontPersonalTeachInfoMapper.updateByPrimaryKey(frontPersonalTeachInfos.get(0));
        }
    }

    @Override
    @SneakyThrows
    public void downloadScoreExcelTemplate(String teachInfoId) {
        String fileName = "UploadStudentScoreInfoDemo.xlsx";

        List<List<String>> header = uploadScoreExcelTemplateHeader.getHeader(teachInfoId);

        List<List<Object>> data = uploadScoreExcelTemplateData.getDataList(teachInfoId);

        HttpServletResponse response = ExcelUtils.setFileResponse(fileName);

        EasyExcel.write(response.getOutputStream())
                .sheet(0)
                .head(header)
                // 设置表头不合并
                .registerWriteHandler(new HorizontalCellStyleStrategy())
                .registerWriteHandler(new AbstractColumnWidthStyleStrategy() {
                    @Override
                    protected void setColumnWidth(WriteSheetHolder writeSheetHolder, List<WriteCellData<?>> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
                        Sheet sheet = writeSheetHolder.getSheet();
                        sheet.setColumnWidth(cell.getColumnIndex(), 5200);
                    }
                })
                .doWrite(data);
    }

    @Override
    public JSONArray queryTeachInfoScores(FrontQueryTeachInfoScoreParams params) {
        FrontPersonalScoreExample frontPersonalScoreExample = new FrontPersonalScoreExample();
        frontPersonalScoreExample.createCriteria().andTeachInfoIdEqualTo(params.getTeachInfoId());

        AtomicInteger i = new AtomicInteger(1);
        List<JSONObject> collect = frontPersonalScoreMapper.selectByExample(frontPersonalScoreExample)
                .stream()
                .peek(e -> e.setId(i.getAndIncrement()))
                .map(FrontPersonalScore::toJsonObject)
                .collect(Collectors.toList());

        return new JSONArray() {{
            addAll(collect);
        }};
    }

    @Override
    public void updateStudentScores(FrontAddStudentScoreParams params) {

        FrontPersonalStudentExample frontPersonalStudentExample = new FrontPersonalStudentExample();
        frontPersonalStudentExample.createCriteria().andStudentIdEqualTo(params.getStudentId());
        List<FrontPersonalStudent> frontPersonalStudents = frontPersonalStudentMapper.selectByExample(frontPersonalStudentExample);
        if (CollectionUtils.isEmpty(frontPersonalStudents)) {
            throw new FrontBusinessException(1003, "学生ID错误，不能修改成绩");
        }

        FrontPersonalScoreExample frontPersonalScoreExample = new FrontPersonalScoreExample();
        frontPersonalScoreExample.createCriteria()
                .andTeachInfoIdEqualTo(params.getTeachInfoId())
                .andStudentIdEqualTo(params.getStudentId());
        List<FrontPersonalScore> scores = frontPersonalScoreMapper.selectByExample(frontPersonalScoreExample);
        if (CollectionUtils.isEmpty(scores)) {
            throw new FrontBusinessException(1003, "该学生未上传过成绩，不能修改成绩");
        }

        FrontPersonalScore frontScore = scores.get(0);
        BeanUtils.copyProperties(params, frontScore);
        JSONArray scoreListJson = new JSONArray();
        scoreListJson.addAll(params.getScoreList());

        frontScore.setScoreList(scoreListJson.toJSONString());

        frontPersonalScoreMapper.updateByExample(frontScore, frontPersonalScoreExample);
    }

    @Override
    public void deleteStudentScores(FrontDeleteStudentScoreParams params) {
        FrontPersonalScoreExample frontPersonalScoreExample = new FrontPersonalScoreExample();
        frontPersonalScoreExample.createCriteria()
                .andTeachInfoIdEqualTo(params.getTeachInfoId())
                .andStudentIdEqualTo(params.getStudentId());

        frontPersonalScoreMapper.deleteByExample(frontPersonalScoreExample);
    }
}
