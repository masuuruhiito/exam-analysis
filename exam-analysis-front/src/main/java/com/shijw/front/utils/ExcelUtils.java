package com.shijw.front.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.shijw.front.excel.vo.ExportStudentScoreBookVO;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 操作Excel工具类
 *
 * @author 浅醉
 * @date 2023/05/12
 */
public class ExcelUtils {

    /**
     * 设置文件类型的 response
     *
     * @param fileName 文件名称
     * @return {@link HttpServletResponse}
     */
    @SneakyThrows
    public static HttpServletResponse setFileResponse(String fileName) {
        HttpServletResponse response = CommonUtil.getResponse();
        //设置响应头
        response.addHeader("Content-Type", "application/vnd.ms-excel;charset=utf-8");
        response.addHeader("Content-Disposition", "attachment;filename*=utf-8''" + java.net.URLEncoder.encode(fileName, "UTF-8"));
        response.addHeader("Access-Control-Expose-Headers", "content-disposition");

//        response.addHeader("Content-Disposition", "attachment; filename=" + fileName);

        return response;
    }

    /**
     * 写文件至 response
     *
     * @param fileName 文件名称
     * @param list     列表
     * @throws IOException ioexception
     */
    public static void writeExcel(String fileName, List<ExportStudentScoreBookVO> list) throws IOException {

        HttpServletResponse response = setFileResponse(fileName);

        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).build();
//        定义工作表对象
        WriteSheet sheet = EasyExcel.writerSheet(0, "sheet").head(ExportStudentScoreBookVO.class).build();
//        向Excel文件中写入数据
        excelWriter.write(list, sheet);
//        关闭输出流
        excelWriter.finish();
    }

    /**
     * 读取excel,放入List<Map<String, String>>
     *
     * @param sheetName sheetName
     * @return datalist
     */
    public static List<Map<String, Object>> readExcelToMap(InputStream inputStream, String sheetName) {
        List<Map<String, Object>> dataList = new ArrayList<>();

        EasyExcel.read(inputStream, new AnalysisEventListener<Map<String, Object>>() {
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
//                System.out.println("Excel读取完成,文件名:" + fileName + ",sheet:" + sheetName + ",行数：" + dataList.size());
            }
        }).sheet(sheetName).doRead();

        return dataList;
    }
}