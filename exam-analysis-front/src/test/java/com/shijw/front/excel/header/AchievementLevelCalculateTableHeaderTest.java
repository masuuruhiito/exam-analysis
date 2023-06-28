package com.shijw.front.excel.header;

import com.alibaba.excel.EasyExcel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author SHI
 * @date 2023/4/20 22:29
 */
@SpringBootTest
class AchievementLevelCalculateTableHeaderTest {

    @Autowired
    private AchievementLevelCalculateTableHeader aa;

    @Test
    void getHeader() {

        String fileName = "./头" + System.currentTimeMillis() + ".xlsx";

        List<List<String>> header = aa.getHeader("TI_1108862387315802112");

        EasyExcel.write(fileName)
                // 这里放入动态头
                .head(header).sheet("TEST")
                .doWrite(new ArrayList<>());
    }
}