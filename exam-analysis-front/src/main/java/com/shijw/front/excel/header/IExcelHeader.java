package com.shijw.front.excel.header;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/20 20:01
 */
public interface IExcelHeader {
    List<List<String>> getHeader(String teachInfoId);
}
