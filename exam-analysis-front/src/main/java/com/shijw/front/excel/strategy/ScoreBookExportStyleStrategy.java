package com.shijw.front.excel.strategy;

import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;

/**
 * @author SHI
 * @date 2023/5/22 23:33
 */
public class ScoreBookExportStyleStrategy {

    public HorizontalCellStyleStrategy getStrategy() {
        // 这里需要设置不关闭流
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        //设置背景颜色
        headWriteCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        //设置头字体
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short) 10);
        headWriteFont.setFontName("宋体");
        headWriteFont.setBold(true);
        headWriteCellStyle.setWriteFont(headWriteFont);
        //设置头居中
        headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        //内容策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        // 设置文本字体大小
        contentWriteCellStyle.setWriteFont(new WriteFont() {{
            setFontHeightInPoints((short) 10);
            setFontName("Arial");
        }});
        //设置 水平居中
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        //内容自动换行，实体类不能加@ContentRowHeight() 注解，否则会挤压数据，造成行高固定
        contentWriteCellStyle.setWrapped(true);
        //设置文本收缩至合适
        contentWriteCellStyle.setShrinkToFit(true);
        // 垂直居中
        contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置左边框
        contentWriteCellStyle.setBorderLeft(BorderStyle.THIN);
        //设置右边框
        contentWriteCellStyle.setBorderRight(BorderStyle.THIN);
        //设置上边框
        contentWriteCellStyle.setBorderTop(BorderStyle.THIN);
        //设置下边框
        contentWriteCellStyle.setBorderBottom(BorderStyle.THIN);

        return new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
    }
}
