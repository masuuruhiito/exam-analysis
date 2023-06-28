package com.shijw.front.excel.data;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/20 20:01
 */
public interface IExcelData {
    List<List<Object>> getDataList(String teachInfoId);
}
