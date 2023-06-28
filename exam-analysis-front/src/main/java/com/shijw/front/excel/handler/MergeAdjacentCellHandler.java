package com.shijw.front.excel.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.excel.enums.CellDataTypeEnum;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.CellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 策略类：相邻单元格值相同合并
 * @author 浅醉
 */
@Component
public class MergeAdjacentCellHandler implements CellWriteHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MergeAdjacentCellHandler.class);

    /**
     * 存放每列上一个单元格的值
     */
    private Map<Integer, Object> lastValueCache = new HashMap<>();

    /**
     * 存放每列上一个单元格的行号
     */
    private Map<Integer, Integer> lastRowIndexCache = new HashMap<>();

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<WriteCellData<?>> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
//        LOGGER.debug("开始处理单元格的值：{}", context.getCellData());
        Integer columnIndex = cell.getColumnIndex();
        Integer rowIndex = cell.getRowIndex();

        Object currentValue = cell.getStringCellValue();
        LOGGER.debug("单元格列下标：{}，行下标：{}，当前值：{}", columnIndex, rowIndex, currentValue);
        // 获取上一个单元格的值和行号
        Object lastValue = lastValueCache.get(columnIndex);
        Integer lastRowIndex = lastRowIndexCache.get(columnIndex);
        LOGGER.debug("单元格列下标：{}，上一个值：{}，上一个行下标：{}", columnIndex, lastValue, lastRowIndex);
        // 判断当前值是否与上一个值相同
        if (currentValue != null && currentValue.equals(lastValue)) {
            // 合并单元格
            LOGGER.debug("当前值与上一个值相同，需要合并单元格");
            int firstRow = lastRowIndex;
            int lastRow = rowIndex;
            int firstCol = columnIndex;
            int lastCol = columnIndex;
            LOGGER.debug("合并单元格：firstRow：{}，lastRow：{}，firstCol：{}，lastCol：{}", firstRow, lastRow, firstCol, lastCol);
            CellStyle cellStyle = cell.getRow().getSheet().getWorkbook().createCellStyle();
            cellStyle.cloneStyleFrom(cell.getCellStyle());
            // 设置单元格样式
            cell.setCellStyle(cellStyle);
            // 合并单元格
            CellRangeAddress cellRangeAddress = new CellRangeAddress(firstRow, lastRow, firstCol, lastCol);
            cell.getRow().getSheet().addMergedRegion(cellRangeAddress);
        } else {
            // 不需要合并单元格，更新缓存
            LOGGER.debug("当前值与上一个值不相同，无需合并单元格");
            lastValueCache.put(columnIndex, currentValue);
            lastRowIndexCache.put(columnIndex, rowIndex);
        }
    }

    /**
     * 清空缓存
     */
    public void clearCache() {
        lastValueCache.clear();
        lastRowIndexCache.clear();
    }
}