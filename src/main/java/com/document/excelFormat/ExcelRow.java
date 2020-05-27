package com.document.excelFormat;

import com.document.DocumentDataStyle;

import java.util.List;

public class ExcelRow {
    private final List data;
    private final DocumentDataStyle style;

    ExcelRow(List data, DocumentDataStyle style) {
        this.data = data;
        this.style = style;
    }
}
