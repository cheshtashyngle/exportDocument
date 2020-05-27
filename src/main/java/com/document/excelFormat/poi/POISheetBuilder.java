package com.document.excelFormat.poi;

import com.document.excelFormat.ExcelRow;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Math.max;

public class POISheetBuilder {

    private final POIRowBuilder rowBuilder;

    public POISheetBuilder(POIRowBuilder rowBuilder) {
        this.rowBuilder = rowBuilder;
    }

    public void build(SXSSFSheet sheet, List<ExcelRow> dataList, CellStyleMap cellStyleMap) {
        sheet.trackAllColumnsForAutoSizing();
        AtomicInteger maxColumnsCount = new AtomicInteger();

        AtomicInteger rowNumber  = new AtomicInteger(0);
        dataList.forEach(dataRow -> {
            Row row = sheet.createRow(rowNumber.getAndIncrement());
            rowBuilder.build(row, dataRow, cellStyleMap);
            int columnsCount = dataRow.dataList.size();
            maxColumnsCount.set(max(maxColumnsCount.get(), columnsCount));
        });

        autoSizeColumns(sheet, maxColumnsCount.get());
    }

    private void autoSizeColumns(SXSSFSheet sheet, int maxColumnsCount) {
        for(int column = 0; column < maxColumnsCount; column ++) {
            sheet.autoSizeColumn(column);
        }
    }
}
