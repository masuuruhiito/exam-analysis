package com.shijw.front.web.params;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author SHI
 * @date 2023/4/14 21:28
 */
@Data
public class FrontStudentRegisterByExcelParams {
    @NotNull(message = "excel文件不能为空！")
    private MultipartFile studentInfoExcel;

    @NotEmpty(message = "班级标识码不能为空！", groups = TheFirstValidProperty.class)
    private String classId;
}
