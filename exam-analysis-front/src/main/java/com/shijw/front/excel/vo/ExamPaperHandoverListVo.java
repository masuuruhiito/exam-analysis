package com.shijw.front.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentLoopMerge;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author SHI
 * @date 2023/4/14 14:00
 * <p>
 * 与学生信息Excel表一一对应
 */
@Data
@EqualsAndHashCode
@ContentRowHeight(45) // 文本行高度
@HeadRowHeight(60) // 标题高度
//@ColumnWidth(5000) // 默认列宽度
public class ExamPaperHandoverListVo {
    @ColumnWidth(25)
    @ExcelProperty("哈尔滨理工大学试卷交接单")
    private Integer one;
    @ColumnWidth(25)
    @ExcelProperty("哈尔滨理工大学试卷交接单")
    private String two;
    @ColumnWidth(25)
    @ExcelProperty("哈尔滨理工大学试卷交接单")
    private String three;
    @ColumnWidth(25)
    @ExcelProperty("哈尔滨理工大学试卷交接单")
    private String four;
    @ColumnWidth(25)
    @ExcelProperty("哈尔滨理工大学试卷交接单")
    private String five;
}
