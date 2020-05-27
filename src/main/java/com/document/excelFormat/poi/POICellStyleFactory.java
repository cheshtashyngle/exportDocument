package com.document.excelFormat.poi;

import com.document.DocumentDataStyle;
import org.apache.poi.ss.usermodel.*;

public class POICellStyleFactory {

    private static final String CALIBRI_FONT_NAME = "Calibri";

    CellStyleMap getCellStyleMap(Workbook workbook) {
        CellStyleMap cellStyleMap = new CellStyleMap();
        cellStyleMap.put(DocumentDataStyle.TITLE, createStyle(workbook, createFontForTitle(workbook)));
        cellStyleMap.put(DocumentDataStyle.RECORD, createStyle(workbook, createFontForRecords(workbook)));
        return cellStyleMap;
    }

    private CellStyle createStyle(Workbook workbook, Font font) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setWrapText(false);
        return cellStyle;
    }

    private Font createFontForTitle(Workbook workbook) {
        Font font = workbook.createFont();
        font.setFontName(CALIBRI_FONT_NAME);
        font.setColor(IndexedColors.RED.getIndex());
        font.setFontHeight((short) (16 * 24));
        font.setBold(true);
        return font;
    }

    private Font createFontForRecords(Workbook workbook) {
        Font font = workbook.createFont();
        font.setFontName(CALIBRI_FONT_NAME);
        font.setColor(IndexedColors.BLUE_GREY.getIndex());
        font.setFontHeight((short) (16 * 16));
        font.setBold(false);
        return font;
    }
}
