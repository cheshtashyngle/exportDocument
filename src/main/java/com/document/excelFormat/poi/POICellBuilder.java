package com.document.excelFormat.poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

public class POICellBuilder {

    public void build(Cell cell, Object data, CellStyle cellStyle) {
        if (data instanceof String) {
            cell.setCellValue((String) data);
        } else if (data instanceof Integer) {
            cell.setCellValue((Integer) data);
        }
        cell.setCellStyle(cellStyle);
    }
}
