package com.document.excelFormat;

import java.io.FileNotFoundException;
import java.util.List;

public interface ExcelWriter {
    void write(String documentPath, String documentName, List<ExcelRow> data) throws FileNotFoundException;
}
