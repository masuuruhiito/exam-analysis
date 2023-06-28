package com.shijw.front.web.params;

import com.shijw.front.model.FrontPersonalClass;
import com.shijw.front.utils.JSONUtils;
import lombok.Data;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotEmpty;
import java.lang.reflect.Field;

/**
 * @author SHI
 * @date 2023/4/13 22:49
 */
@Data
public class FrontClassUpdateParams {

    @NotEmpty(message = "班级标识码不能为空！", groups = TheFirstValidProperty.class)
    private String classId;
    @NotEmpty(message = "学院不能为空！", groups = TheSecondValidProperty.class)
    private String collegeId;
    @NotEmpty(message = "专业不能为空！", groups = TheThirdValidProperty.class)
    private String major;
    @NotEmpty(message = "年级不能为空！", groups = TheFourthValidProperty.class)
    private Integer grade;
    @NotEmpty(message = "班级号不能为空！", groups = TheFifthValidProperty.class)
    private Integer classNumber;


    @SneakyThrows
    public static FrontPersonalClass updateToFrontPersonalClass(FrontClassUpdateParams params, FrontPersonalClass frontPersonalClass) {
        for (Field field : params.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Field frontClassField = null;
            if (field.get(params) == null || !JSONUtils.isExistField(field.getName(), frontPersonalClass)) {
                continue;
            } else {
                frontClassField = FrontPersonalClass.class.getDeclaredField(field.getName());
                frontClassField.setAccessible(true);
            }
            // 如果相同的属性在 params 中不为空，并且与 原本数据库中对象不一致时，进行属性值替换
            if (!String.valueOf(field.get(params)).equals(String.valueOf(frontClassField.get(frontPersonalClass)))) {
                frontClassField.set(frontPersonalClass, field.get(params));
            }
        }
        return frontPersonalClass;
    }
}
