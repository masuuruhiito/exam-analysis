package com.shijw.front.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author SHI
 * @date 2023/4/14 14:00
 * <p>
 * 与学生信息Excel表一一对应
 */
@Data
@EqualsAndHashCode
@ContentRowHeight(15) // 文本行高度
@HeadRowHeight(20) // 标题高度
@ColumnWidth(5000) // 默认列宽度
public class StudentListDataDTO {
    @ExcelProperty("序号")
    private Integer id;
    @ExcelProperty("学号")
    private String studentId;
    @ExcelProperty("学生姓名")
    private String studentName;
    @ExcelProperty("性别")
    private String sex;
    @ExcelProperty("出生日期")
    private String birthday;
    @ExcelProperty("电话")
    private String phoneNumber;
    @ExcelProperty("邮箱")
    private String email;
    @ExcelProperty("地址")
    private String address;
}
