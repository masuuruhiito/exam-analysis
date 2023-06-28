package com.shijw.front.excel.header;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.alibaba.excel.write.style.row.SimpleRowHeightStyleStrategy;
import com.shijw.front.excel.strategy.ExcelDefaultExportStyleStrategy;
import com.shijw.front.excel.strategy.ExcelRowSameValueCellMergeStrategy;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author SHI
 * @date 2023/5/22 23:58
 */
public class StyleTest {

    @SneakyThrows
    public static void main(String[] args) {


    }

    @Test
    @SneakyThrows
    public void genExcel() {
        List<List<String>> header = new ArrayList<List<String>>() {{
            add(Collections.singletonList("哈尔滨理工大学试卷交接单"));
            add(Collections.singletonList("哈尔滨理工大学试卷交接单"));
            add(Collections.singletonList("哈尔滨理工大学试卷交接单"));
            add(Collections.singletonList("哈尔滨理工大学试卷交接单"));
            add(Collections.singletonList("哈尔滨理工大学试卷交接单"));
        }};

        List<List<Object>> data = new ArrayList<List<Object>>() {{
            add(Arrays.asList("aa", "1", 3, 3, 3, "3"));
            add(Arrays.asList("aa", "1", 3, 3, 3, "3"));
            add(Arrays.asList("aa", "1", 3, 3, 3, "3"));
            add(Arrays.asList("aa", "1", 3, 3, 3, "3"));
            add(Arrays.asList("aa", "1", 3, 3, 3, "3"));
        }};

        HttpServletResponse response = new MockHttpServletResponse();
        EasyExcel.write(response.getOutputStream())
                .head(header)
                .registerWriteHandler(new ExcelDefaultExportStyleStrategy().getStrategy())
                .registerWriteHandler(new ExcelRowSameValueCellMergeStrategy())
                // 注册行高列宽样式策略对象
                .registerWriteHandler(new SimpleRowHeightStyleStrategy((short) 50, (short) 28))
                .registerWriteHandler(new SimpleColumnWidthStyleStrategy(15))
                // 导出文件名
                .autoCloseStream(Boolean.TRUE).sheet("问题台账")
                .doWrite(data);
    }
}
