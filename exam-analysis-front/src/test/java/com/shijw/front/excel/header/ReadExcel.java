package com.shijw.front.excel.header;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.io.File;
import java.util.*;

/**
 * @author SHI
 * @date 2023/4/23 19:21
 */
public class ReadExcel {

    public static void main(String[] args) {
//        String fileName = "E:\\Study\\Learn\\Graduation Design\\exam-analysis\\exam-analysis-front\\头1682242973411.xlsx";


//        EasyExcel.read(fileName, new NoModelDataListener()).headRowNumber(7).sheet().doRead();
        String fileName = "D:\\Download File\\Google Download\\UploadStudentScoreInfoDemo (15).xlsx";
        System.out.println(readExcelToMap(fileName, "0").toString());

    }

    /**
     * 读取excel,放入List<Map<String, String>>
     *
     * @param fileName  读取excel的文件名称
     * @param sheetName sheetName
     * @return datalist
     */
    public static List<Map<String, Object>> readExcelToMap(String fileName, String sheetName) {
        List<Map<String, Object>> dataList = new ArrayList<>();

        EasyExcel.read(fileName, new AnalysisEventListener<Map<String, Object>>() {
            //用于存储表头的信息
            private Map<Integer, String> headMap;

            //读取excel表头信息
            @Override
            public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
                this.headMap = headMap;
                System.out.println("表头信息：" + headMap);
            }

            //直接使用Map来保存数据
            @Override
            public void invoke(Map<String, Object> valueData, AnalysisContext context) {
                //把表头和值放入Map
                Map<String, Object> paramsMap = new LinkedHashMap<>();
                for (int i = 0; i < valueData.size(); i++) {
                    String key = headMap.get(i);
                    Object value = valueData.get(i);
                    //将表头作为map的key，每行每个单元格的数据作为map的value
                    paramsMap.put(key, value);
                }
                dataList.add(paramsMap);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                System.out.println("Excel读取完成,文件名:" + fileName + ",sheet:" + sheetName + ",行数：" + dataList.size());
            }
        }).sheet(sheetName).doRead();

        return dataList;
    }
}
