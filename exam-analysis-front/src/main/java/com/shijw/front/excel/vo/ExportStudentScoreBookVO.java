package com.shijw.front.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SHI
 * @date 2023/4/14 22:54
 * todo 修改成绩的类型为double保留一位小数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExportStudentScoreBookVO {
    @ExcelProperty(value = "序号", index = 0)
    private Integer id;
    @ExcelProperty(value = "学号", index = 1)
    private String studentId;
    @ExcelProperty(value = "班级", index = 2)
    private String className;
    @ExcelProperty(value = "姓名", index = 3)
    private String studentName;
    @ExcelProperty(value = "实验成绩", index = 4)
    private Integer experimentScore;
    @ExcelProperty(value = "实践成绩", index = 5)
    private Integer practiceScore;

//    @ExcelProperty(value = "", index = 6)
//    private Integer blankLine1;

    @ExcelProperty(value = "平时成绩", index = 7)
    private Integer usualScore;
    @ExcelProperty(value = "期中成绩", index = 8)
    private Integer midTermScore;
    @ExcelProperty(value = "期末成绩", index = 9)
    private Integer endTermScore;

//    @ExcelProperty(value = "", index = 10)
//    private String blankLine2;

    @ExcelProperty(value = "平时", index = 11)
    private Double usual;
    @ExcelProperty(value = "期末", index = 12)
    private Double endTerm;
    @ExcelProperty(value = "总评", index = 13)
    private Double overall;
}
