package com.shijw.front.excel.header;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author SHI
 * @date 2023/5/24 20:21
 */
@Component
public class ScoreAnalysisTableHeader implements IExcelHeader {

    @Override
    public List<List<String>> getHeader(String teachInfoId) {
        return new ArrayList<List<String>>() {{
            for (int i = 0; i < 10; i++) {
                add(Collections.singletonList("成 绩 分 析 表"));
            }
        }};
    }
}
