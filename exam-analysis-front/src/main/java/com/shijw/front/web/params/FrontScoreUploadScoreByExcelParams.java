package com.shijw.front.web.params;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author SHI
 * @date 2023/4/14 22:09
 */
@Data
public class FrontScoreUploadScoreByExcelParams {

//    @NotNull(message = "上传学生成绩的文件不能为空", groups = TheSecondValidProperty.class)
    private MultipartFile studentScoreExcel;

//    @NotEmpty(message = "班级标识码不能为空！", groups = TheFirstValidProperty.class)
//    private String classId;
//
//    @NotEmpty(message = "课程标识码不能为空！", groups = TheFirstValidProperty.class)
//    private String courseId;

    @NotEmpty(message = "课程标识码不能为空！", groups = TheFirstValidProperty.class)
    private String teachInfoId;
}
