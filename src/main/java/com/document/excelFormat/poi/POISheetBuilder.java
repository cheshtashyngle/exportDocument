package com.document.excelFormat.poi;

import com.document.excelFormat.ExcelRow;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class POISheetBuilder {

    private final POIRowBuilder rowBuilder;

    public POISheetBuilder(POIRowBuilder rowBuilder) {
        this.rowBuilder = rowBuilder;
    }

    public void build(Sheet sheet, List<ExcelRow> dataList) {
        AtomicInteger rowNumber  = new AtomicInteger(0);
        dataList.forEach(dataRow -> {
            Row row = sheet.createRow(rowNumber.getAndIncrement());
            rowBuilder.build(row, dataRow);
        });
    }
}
