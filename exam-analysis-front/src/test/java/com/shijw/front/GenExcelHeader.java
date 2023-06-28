package com.shijw.front;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SHI
 * @date 2023/4/20 19:51
 */
public class GenExcelHeader {

    public static void main(String[] args) {
        String fileName = "./头" + System.currentTimeMillis() + ".xlsx";

        List<List<String>> dataList = new ArrayList<>();
        List<List<String>> header = new ArrayList<>();

        ArrayList<String> objects = new ArrayList<>();
        objects.add("!111111");
        dataList.add(objects);

        List<String> cellContain1 = new ArrayList<>();
        cellContain1.add("大连");
        cellContain1.add("中山区");
        cellContain1.add("中山广场");
        header.add(cellContain1);

        List<String> cellContain2 = new ArrayList<>();
        cellContain2.add("大连");
        cellContain2.add("沙河口区");
        cellContain2.add("中山广场");
        header.add(cellContain2);

        List<String> cellContain3 = new ArrayList<>();
        cellContain3.add("成都");
        cellContain3.add("锦江区");
        cellContain3.add("中山广场");
        header.add(cellContain3);

        List<String> cellContain4 = new ArrayList<>();
        cellContain4.add("成都");
        cellContain4.add("青羊区");
        cellContain4.add("万达广场");
        header.add(cellContain4);

        List<String> cellContain5 = new ArrayList<>();
        cellContain5.add("大连");
        cellContain5.add("甘井子区");
        header.add(cellContain5);

        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        // 背景设置为红色
        headWriteCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short)18);
        headWriteCellStyle.setWriteFont(headWriteFont);



        WriteCellDemoData writeCellDemoData = new WriteCellDemoData();
        WriteCellData<String> writeCellStyle = new WriteCellData<>("单元格样式");
        writeCellStyle.setType(CellDataTypeEnum.STRING);
        writeCellDemoData.setWriteCellStyle(writeCellStyle);
        WriteCellStyle writeCellStyleData = new WriteCellStyle();
        writeCellStyle.setWriteCellStyle(writeCellStyleData);
        // 这里需要指定 FillPatternType 为FillPatternType.SOLID_FOREGROUND 不然无法显示背景颜色.
        writeCellStyleData.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
        // 背景绿色
        writeCellStyleData.setFillForegroundColor(IndexedColors.GREEN.getIndex());






        // 内容的策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        // 这个策略是 头是头的样式 内容是内容的样式 其他的策略可以自己实现
        HorizontalCellStyleStrategy horizontalCellStyleStrategy =
                new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);

        EasyExcel.write(fileName, WriteCellDemoData.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                // 这里放入动态头
                .head(header).sheet("TEST")
                .doWrite(dataList);
    }
}
