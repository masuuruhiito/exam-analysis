package com.shijw.front.excel.strategy;

import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 浅醉
 */
@NoArgsConstructor
public class ExcelColumnSameValueCellMergeStrategy implements CellWriteHandler {

    private int startRowNumber;
    private int endRowNumber;

    private Deque<Object> lastRowDataList = new ArrayDeque<>();

    public ExcelColumnSameValueCellMergeStrategy(int startRowNumber, int endRowNumber) {
        this.startRowNumber = startRowNumber;
        this.endRowNumber = endRowNumber;
    }

    @Override
    public void afterCellDispose(CellWriteHandlerContext context) {
        if (context.getHead()) {
            return;
        }
        Integer rowIndex = context.getRowIndex();
        Integer columnIndex = context.getColumnIndex();
        Serializable value = CellType.STRING.equals(context.getCell().getCellType()) ? context.getCell().getStringCellValue() : context.getCell().getNumericCellValue();

        if (endRowNumber != 0 && (rowIndex > endRowNumber || rowIndex < startRowNumber)) {
            return;
        }

        if (endRowNumber == 0 && rowIndex == 0 || endRowNumber != 0 && rowIndex == startRowNumber) {

        } else if (value.equals(lastRowDataList.getFirst())) {
            Sheet sheet = context.getWriteSheetHolder().getSheet();
            List<CellRangeAddress> mergeRegions = sheet.getMergedRegions();
            boolean isMerged = false;
            for (int i = 0; i < mergeRegions.size() && !isMerged; i++) {
                CellRangeAddress cellRangeAddr = mergeRegions.get(i);
                // 若上一个单元格已经被合并，则先移出原有的合并单元，再重新添加合并单元
                if (cellRangeAddr.isInRange(rowIndex - 1, columnIndex)) {
                    sheet.removeMergedRegion(i);
                    cellRangeAddr.setLastRow(rowIndex);
                    sheet.addMergedRegion(cellRangeAddr);
                    isMerged = true;
                }
            }
            // 若上一个单元格未被合并，则新增合并单元
            if (!isMerged) {
                CellRangeAddress cellRangeAddress = new CellRangeAddress(rowIndex - 1, rowIndex, columnIndex, columnIndex);
                sheet.addMergedRegion(cellRangeAddress);
            }
            lastRowDataList.pollFirst();
        } else if (!value.equals(lastRowDataList.getFirst())) {
            lastRowDataList.pollFirst();
        }
        lastRowDataList.addLast(value);
    }
}