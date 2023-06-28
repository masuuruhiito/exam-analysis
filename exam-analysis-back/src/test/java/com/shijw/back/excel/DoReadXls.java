package com.shijw.back.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

/**
 * @author SHI
 * @date 2023/4/9 22:40
 */
public class DoReadXls {
    public static void main(String[] args) {
        String fileName = "E:\\Study\\Learn\\Graduation Design\\exam-analysis\\exam-analysis-back\\src\\test\\java\\com\\shijw\\back\\excel\\university.xls";

        EasyExcel.read(fileName, UniversityData.class, new PageReadListener<UniversityData>(dataList -> {
            for (UniversityData demoData : dataList) {
                // 控制台打印格式
                // put("id", new UniversityInfoDto("id", "name", "code"));
                if (StringUtils.isNumericSpace(demoData.getId())) {
                    System.out.println("put(\"" + demoData.getId() + "\", new UniversityInfoDto(\"" + demoData.getId() + "\", \"" + demoData.getName() + "\", \"" + demoData.getCode() + "\"));");
                }


            }
        })).sheet().doRead();



    }
}
