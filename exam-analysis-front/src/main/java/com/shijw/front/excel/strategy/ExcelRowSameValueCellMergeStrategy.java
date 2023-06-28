package com.shijw.front.excel.strategy;

import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @author 浅醉
 */
@NoArgsConstructor
public class ExcelRowSameValueCellMergeStrategy implements CellWriteHandler {

    private int startRowNumber;
    private int endRowNumber;

    private Object curRowLastValue;

    public ExcelRowSameValueCellMergeStrategy(int startRowNumber, int endRowNumber) {
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

        if (columnIndex != 0 && value.equals(curRowLastValue)) {
            Sheet sheet = context.getWriteSheetHolder().getSheet();
            List<CellRangeAddress> mergeRegions = sheet.getMergedRegions();
            boolean isMerged = false;
            for (int i = 0; i < mergeRegions.size() && !isMerged; i++) {
                CellRangeAddress cellRangeAddr = mergeRegions.get(i);
                // 若上一个单元格已经被合并，则先移出原有的合并单元，再重新添加合并单元
                if (cellRangeAddr.isInRange(rowIndex, columnIndex - 1)) {
                    sheet.removeMergedRegion(i);
                    cellRangeAddr.setLastColumn(columnIndex);
                    sheet.addMergedRegion(cellRangeAddr);
                    isMerged = true;
                }
            }
            // 若上一个单元格未被合并，则新增合并单元
            if (!isMerged) {
                CellRangeAddress cellRangeAddress = new CellRangeAddress(rowIndex, rowIndex, columnIndex - 1, columnIndex);
                sheet.addMergedRegion(cellRangeAddress);
            }
        }
        curRowLastValue = value;
    }
}