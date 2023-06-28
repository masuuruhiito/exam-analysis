package com.shijw.front.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.style.column.AbstractHeadColumnWidthStyleStrategy;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.alibaba.excel.write.style.row.AbstractRowHeightStyleStrategy;
import com.alibaba.excel.write.style.row.SimpleRowHeightStyleStrategy;
import com.shijw.front.excel.data.*;
import com.shijw.front.excel.handler.MergeAdjacentCellHandler;
import com.shijw.front.excel.header.*;
import com.shijw.front.excel.strategy.*;
import com.shijw.front.excel.vo.ExamPaperHandoverListVo;
import com.shijw.front.exception.FrontBusinessException;
import com.shijw.front.mapper.FrontPersonalClassMapper;
import com.shijw.front.mapper.FrontPersonalCourseMapper;
import com.shijw.front.mapper.FrontPersonalScoreMapper;
import com.shijw.front.mapper.FrontPersonalTeachInfoMapper;
import com.shijw.front.model.FrontPersonalClass;
import com.shijw.front.model.FrontPersonalCourse;
import com.shijw.front.model.FrontPersonalScore;
import com.shijw.front.model.FrontPersonalTeachInfo;
import com.shijw.front.excel.vo.ExportStudentScoreBookVO;
import com.shijw.front.model.dto.CourseClassScoreInfoDTO;
import com.shijw.front.model.example.*;
import com.shijw.front.service.IFrontScoreAnalysisService;
import com.shijw.front.utils.ExcelMergeUtil;
import com.shijw.front.utils.ExcelUtils;
import com.shijw.front.web.params.FrontScoreAnalysisParams;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author SHI
 * @date 2023/4/15 12:07
 */
@Service
public class FrontScoreAnalysisServiceImpl implements IFrontScoreAnalysisService {

    @Autowired
    private FrontPersonalTeachInfoMapper frontPersonalTeachInfoMapper;
    @Autowired
    private FrontPersonalClassMapper frontPersonalClassMapper;
    @Autowired
    private FrontPersonalCourseMapper frontPersonalCourseMapper;
    @Autowired
    private FrontPersonalScoreMapper frontPersonalScoreMapper;
    @Autowired
    private AchievementLevelCalculateTableHeader achievementLevelCalculateTableHeader;
    @Autowired
    private AchievementLevelCalculateTableData achievementLevelCalculateTableData;
    @Autowired
    private ExamPaperHandoverListHeader examPaperHandoverListHeader;
    @Autowired
    private ExamPaperHandoverListData examPaperHandoverListData;
    @Autowired
    private ScoreBookData scoreBookData;
    @Autowired
    private ScoreBookHeader scoreBookHeader;
    @Autowired
    private FinalExamQuestionsAndCourseContrastTableHeader finalExamQuestionsAndCourseContrastTableHeader;
    @Autowired
    private FinalExamQuestionsAndCourseContrastTableData finalExamQuestionsAndCourseContrastTableData;
    @Autowired
    private ScoreAnalysisTableData scoreAnalysisTableData;
    @Autowired
    private ScoreAnalysisTableHeader scoreAnalysisTableHeader;


    @Override
    @SneakyThrows

    public void exportScoreBook(FrontScoreAnalysisParams params) {
        // 通过 teach info id 获取 course class score info
        CourseClassScoreInfoDTO infoDTO = getCourseClassScoreInfoDtoByTeachInfoId(params.getTeachInfoId());

        FrontPersonalClass classInfo = infoDTO.getClassInfo();
        FrontPersonalCourse courseInfo = infoDTO.getCourseInfo();
        List<ExportStudentScoreBookVO> scoreBookList = FrontPersonalScore.toScoreBookDTOList(infoDTO.getScoreBookList());

        // 拼出导出文件名称：课程名+"-"+专业名+班级名+计分册.xlsx （例：Java程序设计-计算机19-5班计分册.xlsx）
        String fileName = courseInfo.getCourseName() + "-"
                + classInfo.getMajor() + classInfo.getGrade() + "-" + classInfo.getClassNumber()
                + "计分册.xlsx";

        ExcelUtils.writeExcel(fileName, scoreBookList);
    }

    @Override
    @SneakyThrows
    public void exportAchievementLevelCalculateTable(FrontScoreAnalysisParams params) {

        CourseClassScoreInfoDTO infoDTO = getCourseClassScoreInfoDtoByTeachInfoId(params.getTeachInfoId());
        FrontPersonalClass classInfo = infoDTO.getClassInfo();
        FrontPersonalCourse courseInfo = infoDTO.getCourseInfo();

        List<List<String>> header = achievementLevelCalculateTableHeader.getHeader(params.getTeachInfoId());

        List<List<Object>> dataList = achievementLevelCalculateTableData.getDataList(params.getTeachInfoId());

        // 拼出导出文件名称：课程名+"-"+专业名+班级名+计分册.xlsx （例：Java程序设计-计算机19-5班计分册.xlsx）
        String fileName = courseInfo.getCourseName() + "-"
                + classInfo.getMajor() + classInfo.getGrade() + "-" + classInfo.getClassNumber()
                + "达成度分析表.xlsx";

        HttpServletResponse response = ExcelUtils.setFileResponse(fileName);

        EasyExcel.write(response.getOutputStream())
                // 这里放入动态头
                .head(header).sheet()
                .doWrite(dataList);
    }

    @Override
    public CourseClassScoreInfoDTO getCourseClassScoreInfoDtoByTeachInfoId(String teachInfoId) {
        // 验证 teach_info_id 是否正确
        // todo 支持查询后台
        FrontPersonalTeachInfoExample frontPersonalTeachInfoExample = new FrontPersonalTeachInfoExample();
        frontPersonalTeachInfoExample.createCriteria().andTeachInfoIdEqualTo(teachInfoId);
        List<FrontPersonalTeachInfo> personalTeachInfos = frontPersonalTeachInfoMapper.selectByExample(frontPersonalTeachInfoExample);
        if (CollectionUtils.isEmpty(personalTeachInfos)) {
            // todo 填写异常
            throw new FrontBusinessException(111, "任教信息为空，请检查教授信息标识码！");
        }
        FrontPersonalTeachInfo teachInfo = personalTeachInfos.get(0);

        // 获取 class info
        FrontPersonalClassExample frontPersonalClassExample = new FrontPersonalClassExample();
        frontPersonalClassExample.createCriteria().andClassIdEqualTo(teachInfo.getClassId());
        List<FrontPersonalClass> frontPersonalClasses = frontPersonalClassMapper.selectByExample(frontPersonalClassExample);
        FrontPersonalClass classInfo = frontPersonalClasses.get(0);

        // 获取 course info
        FrontPersonalCourseExample frontPersonalCourseExample = new FrontPersonalCourseExample();
        frontPersonalCourseExample.createCriteria().andCourseIdEqualTo(teachInfo.getCourseId());
        List<FrontPersonalCourse> personalCourses = frontPersonalCourseMapper.selectByExample(frontPersonalCourseExample);

        FrontPersonalCourse courseInfo = personalCourses.get(0);

        // 获取 score info
        FrontPersonalScoreExample frontPersonalScoreExample = new FrontPersonalScoreExample();
        frontPersonalScoreExample.createCriteria().andTeachInfoIdEqualTo(teachInfoId);
        frontPersonalScoreExample.setOrderByClause("student_id asc");
        List<FrontPersonalScore> personalScores = frontPersonalScoreMapper.selectByExample(frontPersonalScoreExample);

        List<ExportStudentScoreBookVO> scoreBookList = FrontPersonalScore.toScoreBookDTOList(personalScores);
        // 填入序号
        AtomicReference<Integer> id = new AtomicReference<>(1);
        scoreBookList.forEach(e -> e.setId(id.getAndSet(id.get() + 1)));

        return CourseClassScoreInfoDTO.builder()
                .courseInfo(courseInfo)
                .classInfo(classInfo)
                .teachInfo(teachInfo)
                .scoreBookList(personalScores)
                .build();
    }

    @Override
    @SneakyThrows
    public void exportTeachingRecord(FrontScoreAnalysisParams params) {
        CourseClassScoreInfoDTO infoDTO = getCourseClassScoreInfoDtoByTeachInfoId(params.getTeachInfoId());
        FrontPersonalClass classInfo = infoDTO.getClassInfo();
        FrontPersonalCourse courseInfo = infoDTO.getCourseInfo();

        String fileName = courseInfo.getCourseName() + "-"
                + classInfo.getMajor() + classInfo.getGrade() + "-" + classInfo.getClassNumber()
                + "教学档案存档内容.xlsx";

        HttpServletResponse response = ExcelUtils.setFileResponse(fileName);

        // 写到不同的sheet 不同的对象
        try (ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).build()) {

            // 表0-试卷交接单
            writeExamPaperHandoverList(excelWriter, params.getTeachInfoId());

            // 表1-记分册
            writeScoreBook(excelWriter, params.getTeachInfoId());

            // 表2-哈尔滨理工大学期末考试命题与课程目标对应表
            writeFinalExamQuestionsAndCourseContrastTable(excelWriter, params.getTeachInfoId());

            // 哈尔滨理工大学课程目标、毕业要求达成度计算表-1
            writeAchievementLevelCalculateTable(excelWriter, params.getTeachInfoId());

            // 成 绩 分 析 表
            writeScoreAnalysisTable(excelWriter, params.getTeachInfoId());
        }
    }

    private void writeExamPaperHandoverList(ExcelWriter excelWriter, String teachInfoId) {
        WriteSheet writeSheet = EasyExcel.writerSheet(1, "表0-试卷交接单")
                .head(ExamPaperHandoverListVo.class)
                .registerWriteHandler(new ExcelDefaultExportStyleStrategy().getStrategy())
                .registerWriteHandler(new ExcelRowSameValueCellMergeStrategy())
                .registerWriteHandler(new SimpleColumnWidthStyleStrategy(18))
                .registerWriteHandler(new AbstractRowHeightStyleStrategy() {

                    @Override
                    protected void setHeadColumnHeight(Row row, int relativeRowIndex) {
                        row.setHeightInPoints(50);
                    }

                    @Override
                    protected void setContentColumnHeight(Row row, int relativeRowIndex) {
                        if (relativeRowIndex == 18) {
                            row.setHeightInPoints(70);
                        } else {
                            row.setHeightInPoints(28);
                        }
                    }
                })
                .build();

        List<List<Object>> data = examPaperHandoverListData.getDataList(teachInfoId);

        excelWriter.write(data, writeSheet);
    }

    private void writeScoreBook(ExcelWriter excelWriter, String teachInfoId) {

        List<List<String>> header = scoreBookHeader.getHeader(teachInfoId);
        List<List<Object>> dataList = scoreBookData.getDataList(teachInfoId);

        WriteSheet writeSheet = EasyExcel.writerSheet(2, "表1-记分册")
                .head(header)
                .registerWriteHandler(new ScoreBookExportStyleStrategy().getStrategy())
                .registerWriteHandler(new SimpleColumnWidthStyleStrategy(15))
                .registerWriteHandler(new SimpleRowHeightStyleStrategy((short) 16, (short) 16))
                .build();

        excelWriter.write(dataList, writeSheet);
    }

    private void writeFinalExamQuestionsAndCourseContrastTable(ExcelWriter excelWriter, String teachInfoId) {

        List<List<String>> header = finalExamQuestionsAndCourseContrastTableHeader.getHeader(teachInfoId);
        List<List<Object>> dataList = finalExamQuestionsAndCourseContrastTableData.getDataList(teachInfoId);

        WriteSheet writeSheet = EasyExcel.writerSheet(3, "表2-哈尔滨理工大学期末考试命题与课程目标对应表")
                .head(header)
                .registerWriteHandler(new ExcelDefaultExportStyleStrategy().getStrategy())
                .registerWriteHandler(new ExcelRowSameValueCellMergeStrategy(10, 100))
                .registerWriteHandler(new SimpleColumnWidthStyleStrategy(18))
                .registerWriteHandler(new AbstractRowHeightStyleStrategy() {

                    @Override
                    protected void setHeadColumnHeight(Row row, int relativeRowIndex) {
                        row.setHeightInPoints(50);
                    }

                    @Override
                    protected void setContentColumnHeight(Row row, int relativeRowIndex) {
                        if (relativeRowIndex >= 2 && relativeRowIndex <= 8) {
                            row.setHeightInPoints(70);
                        } else {
                            row.setHeightInPoints(28);
                        }
                    }
                })
                .build();
        excelWriter.write(dataList, writeSheet);
    }

    private void writeAchievementLevelCalculateTable(ExcelWriter excelWriter, String teachInfoId) {

        List<List<String>> header = achievementLevelCalculateTableHeader.getHeader(teachInfoId);
        List<List<Object>> dataList = achievementLevelCalculateTableData.getDataList(teachInfoId);

        WriteSheet writeSheet = EasyExcel.writerSheet(4, "哈尔滨理工大学课程目标、毕业要求达成度计算表-1")
                .head(header)
                .registerWriteHandler(new AchievementLevelCalculateStyleStrategy().getStrategy())
                .registerWriteHandler(new SimpleColumnWidthStyleStrategy(16))
                .registerWriteHandler(new AbstractRowHeightStyleStrategy() {

                    @Override
                    protected void setHeadColumnHeight(Row row, int relativeRowIndex) {
                        if (relativeRowIndex == 0) {
                            row.setHeightInPoints(35);
                        } else {
                            row.setHeightInPoints(15);
                        }
                    }

                    @Override
                    protected void setContentColumnHeight(Row row, int relativeRowIndex) {
                        row.setHeightInPoints(15);
                    }
                })
                .build();
        excelWriter.write(dataList, writeSheet);
    }

    private void writeScoreAnalysisTable(ExcelWriter excelWriter, String teachInfoId) {
        List<List<String>> header = scoreAnalysisTableHeader.getHeader(teachInfoId);
        List<List<Object>> dataList = scoreAnalysisTableData.getDataList(teachInfoId);

        WriteSheet writeSheet = EasyExcel.writerSheet(5, "成绩分析表-1")
                .head(header)
                .registerWriteHandler(new AchievementLevelCalculateStyleStrategy().getStrategy())
                .registerWriteHandler(new SimpleColumnWidthStyleStrategy(13))
                .registerWriteHandler(new ExcelColumnSameValueCellMergeStrategy(8, 15))
                .registerWriteHandler(new ExcelRowSameValueCellMergeStrategy(0, 100))
                .registerWriteHandler(new AbstractRowHeightStyleStrategy() {

                    @Override
                    protected void setHeadColumnHeight(Row row, int relativeRowIndex) {
                        row.setHeightInPoints(36);
                    }

                    @Override
                    protected void setContentColumnHeight(Row row, int relativeRowIndex) {
                        if (relativeRowIndex == 15 || relativeRowIndex == 16) {
                            row.setHeightInPoints(110);
                        } else {
                            row.setHeightInPoints(35);
                        }

                    }
                })
                .build();

        excelWriter.write(dataList, writeSheet);
    }
}