package com.shijw.front.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author SHI
 * @date 2023/4/14 21:49
 */
@Getter
@Setter
@EqualsAndHashCode
@ContentRowHeight(15) // 文本行高度
@HeadRowHeight(20) // 标题高度
@ColumnWidth(5000) // 默认列宽度
public class UploadStudentScoreDataDTO {
    @ExcelProperty("学号")
    private String studentId;
    @ExcelProperty("姓名")
    private String studentName;
    @ExcelProperty("作业成绩")
    private Double homeworkScore;
    @ExcelProperty("实验成绩")
    private Double experimentScore;
    @ExcelProperty("实践成绩")
    private Double practiceScore;
    @ExcelProperty("案例成绩")
    private Double caseScore;
    @ExcelProperty("课堂表现成绩")
    private Double performanceScore;
    @ExcelProperty("过程性考核成绩")
    private Double processEvaluationScore;
    @ExcelProperty("平时成绩")
    private Double usualScore;
    @ExcelProperty("期中成绩")
    private Double midTermScore;
    @ExcelProperty("期末成绩")
    private Double endTermScore;
}
