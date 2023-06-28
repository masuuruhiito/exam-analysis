package com.shijw.back.constant;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.shijw.back.exception.BackException;
import com.shijw.back.model.dto.UniversityDataDto;
import com.shijw.back.model.dto.UniversityInfoDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SHI
 * @date 2023/4/9 22:44
 */
public class UniversityInfoConstant {

    public static final Map<String, UniversityInfoDto> UNIVERSITY_INFO_MAP = new HashMap<String, UniversityInfoDto>() {{

        try {
            File file = ResourceUtils.getFile("classpath:excel/university_info.xls");
            EasyExcel.read(file, UniversityDataDto.class, new PageReadListener<UniversityDataDto>(dataList -> {
                for (UniversityDataDto demoData : dataList) {
                    // xls 文件中有几行数据 id列不为数字，不是学校数据 所以需排除
                    if (StringUtils.isNumericSpace(demoData.getId())) {
                        put(demoData.getCode(), new UniversityInfoDto(demoData.getName(), demoData.getCode()));
                    }
                }
            })).sheet().doRead();
        } catch (Exception e) {
            throw new BackException(500, "初始化UNIVERSITY_INFO_MAP失败：" + e);
        }
    }};
}
