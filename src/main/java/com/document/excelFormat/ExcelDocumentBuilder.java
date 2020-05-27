package com.document.excelFormat;

import com.document.DocumentBuilder;
import com.document.DocumentData;
import com.document.RecordMap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.document.DocumentDataStyle.*;

public class ExcelDocumentBuilder implements DocumentBuilder {

    private final ExcelWriter excelWriter;

    public ExcelDocumentBuilder(ExcelWriter excelWriter) {
        this.excelWriter = excelWriter;
    }

    @Override
    public String build(DocumentData data) {
        List<ExcelRow> dataForExcel = getDataInRowsFormat(data);
        try {
            excelWriter.write(data.getDocumentName(), dataForExcel);
        } catch (Exception exception) {
            return exception.getLocalizedMessage();
        }
        return dataForExcel.toString();
    }

    private List<ExcelRow> getDataInRowsFormat(DocumentData data) {
        List<ExcelRow> excelRows = new ArrayList<>();
        excelRows.add(getTitlesRow(data));
        excelRows.addAll(getRecordRows(data));
        return excelRows;
    }

    private ExcelRow getTitlesRow(DocumentData data) {
        List<Object> titleRow = new ArrayList<>(data.getRecordsTitles());
        return new ExcelRow(titleRow, TITLE);
    }

    private List<ExcelRow> getRecordRows(DocumentData data) {
        List<String> titles = data.getRecordsTitles();
        return data.getRecordMapsList().stream().map(recordMap -> {
            List<Object> recordList = getRecordList(titles, recordMap);
            return new ExcelRow(recordList, RECORD);
        }).collect(Collectors.toList());
    }

    private List<Object> getRecordList(List<String> titles, RecordMap recordMap) {
        return titles.stream().map(recordMap::get).collect(Collectors.toList());
    }

}
