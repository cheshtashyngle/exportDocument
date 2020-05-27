package com.document.excelFormat.poi;

import com.document.excelFormat.ExcelRow;
import com.document.excelFormat.ExcelWriter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class POIExcelWriter implements ExcelWriter {

    private final POISheetBuilder sheetBuilder;

    public POIExcelWriter(POISheetBuilder sheetBuilder) {
        this.sheetBuilder = sheetBuilder;
    }

    @Override
    public void write(String documentPath, String documentName, List<ExcelRow> data) throws IOException {
        String excelFileNameWithPath = getExcelFileName(documentPath, documentName);
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(documentName);
        sheetBuilder.build(sheet, data);

        FileOutputStream fileOutputStream = new FileOutputStream(excelFileNameWithPath);
        workbook.write(fileOutputStream);
    }

    private String getExcelFileName(String documentPath, String documentName) {
        return documentPath + "/" + documentName + ".xlsx";
    }


}
