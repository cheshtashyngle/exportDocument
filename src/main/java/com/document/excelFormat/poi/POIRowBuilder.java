package com.document.excelFormat.poi;

import com.document.excelFormat.ExcelRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.concurrent.atomic.AtomicInteger;

public class POIRowBuilder {

    private final POICellBuilder cellBuilder;

    public POIRowBuilder(POICellBuilder cellBuilder) {
        this.cellBuilder = cellBuilder;
    }

    public void build(Row row, ExcelRow dataRow) {
        AtomicInteger rowNumber = new AtomicInteger(0);
        dataRow.dataList.forEach(data -> {
            Cell cell = row.createCell(rowNumber.getAndIncrement());
            cellBuilder.build(cell, data);
        });
    }
}
