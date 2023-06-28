package com.shijw.front.excel.header;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author SHI
 * @date 2023/5/21 15:15
 */
@Component
public class ExamPaperHandoverListHeader implements IExcelHeader {

    @Override
    public List<List<String>> getHeader(String teachInfoId) {
        return new ArrayList<List<String>>() {{
            add(Collections.singletonList("哈尔滨理工大学试卷交接单"));
            add(Collections.singletonList("哈尔滨理工大学试卷交接单"));
            add(Collections.singletonList("哈尔滨理工大学试卷交接单"));
            add(Collections.singletonList("哈尔滨理工大学试卷交接单"));
            add(Collections.singletonList("哈尔滨理工大学试卷交接单"));
        }};
    }
}
