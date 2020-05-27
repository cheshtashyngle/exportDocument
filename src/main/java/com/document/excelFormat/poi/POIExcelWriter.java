package com.document.excelFormat.poi;

import com.document.excelFormat.ExcelRow;
import com.document.excelFormat.ExcelWriter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class POIExcelWriter implements ExcelWriter {

    private final POISheetBuilder sheetBuilder;
    private final POICellStyleFactory cellStyleFactory;

    public POIExcelWriter(POISheetBuilder sheetBuilder, POICellStyleFactory cellStyleBuilder) {
        this.sheetBuilder = sheetBuilder;
        this.cellStyleFactory = cellStyleBuilder;
    }

    @Override
    public void write(String documentName, List<ExcelRow> data) throws IOException {
        String excelFileNameWithPath = getExcelFileName(documentName);
        Workbook workbook = new SXSSFWorkbook();

        CellStyleMap cellStyleMap = cellStyleFactory.getCellStyleMap(workbook);

        SXSSFSheet sheet = (SXSSFSheet) workbook.createSheet(documentName);
        sheetBuilder.build(sheet, data, cellStyleMap);

        FileOutputStream fileOutputStream = new FileOutputStream(excelFileNameWithPath);
        workbook.write(fileOutputStream);
    }

    private String getExcelFileName(String documentName) {
        return documentName + ".xlsx";
    }
}
