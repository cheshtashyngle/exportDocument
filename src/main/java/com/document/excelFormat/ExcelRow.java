package com.document.excelFormat;

import com.document.DocumentDataStyle;

import java.util.List;

public class ExcelRow {
    public final List<Object> dataList;
    public final DocumentDataStyle style;

    ExcelRow(List<Object> dataList, DocumentDataStyle style) {
        this.dataList = dataList;
        this.style = style;
    }
}
