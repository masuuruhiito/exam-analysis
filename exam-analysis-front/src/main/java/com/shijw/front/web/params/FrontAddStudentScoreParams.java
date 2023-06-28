package com.shijw.front.web.params;

import com.shijw.front.model.dto.StudentScoreDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author SHI
 * @date 2023/5/17 16:33
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FrontAddStudentScoreParams {
    @NotEmpty(message = "教授关系标识码不能为空！", groups = TheFirstValidProperty.class)
    private String teachInfoId;

    @NotEmpty(message = "学生ID不能为空！", groups = TheSecondValidProperty.class)
    private String studentId;

    private List<StudentScoreDTO> scoreList;

    private Double usualScore;

    private Double midTermScore;

    private Double endTermScore;
}
