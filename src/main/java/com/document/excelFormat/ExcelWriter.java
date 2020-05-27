package com.document.excelFormat;

import java.util.List;

public interface ExcelWriter {
    void write(String documentName, List<ExcelRow> data) throws Exception;
}
