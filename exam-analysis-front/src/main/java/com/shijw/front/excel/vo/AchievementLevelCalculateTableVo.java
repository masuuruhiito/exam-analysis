package com.shijw.front.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;

/**
 * @author SHI
 * @date 2023/4/19 18:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AchievementLevelCalculateTableVo {
    @ExcelProperty({"哈尔滨理工大学课程目标、毕业要求达成度计算表", "专业", "课程名称", "序号"})
    private Integer id;
    @ExcelProperty({"哈尔滨理工大学课程目标、毕业要求达成度计算表", "专业", "课程名称", "序号"})
    private String studentId;
    @ExcelProperty(value = "学生姓名", index = 2)
    private String className;
    @ExcelProperty(value = "姓名", index = 3)
    private String studentName;
    @ExcelProperty(value = "实验成绩", index = 4)
    private Integer experimentScore;
    @ExcelProperty(value = "实践成绩", index = 5)
    private Integer practiceScore;

    @ExcelProperty(value = "", index = 6)
    private Integer blankLine1;

    @ExcelProperty(value = "平时成绩", index = 7)
    private Integer usualScore;
    @ExcelProperty(value = "期中成绩", index = 8)
    private Integer midTermScore;
    @ExcelProperty(value = "期末成绩", index = 9)
    private Integer endTermScore;

    @ExcelProperty(value = "", index = 10)
    private String blankLine2;

    @ExcelProperty(value = "平时", index = 11)
    private Double usual;
    @ExcelProperty(value = "期末", index = 12)
    private Double endTerm;
    @ExcelProperty(value = "总评", index = 13)
    private Double overall;
}
