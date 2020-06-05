package com.document.jasper;

import java.util.List;

public class GridData<RecordType> {

    private final List<ColumnData> columnDataList;
    private final List<RecordType> recordList;

    public GridData(List<ColumnData> columnDataList, List<RecordType> recordList) {
        this.columnDataList = columnDataList;
        this.recordList = recordList;
    }

    public List<ColumnData> getColumnDataList() {
        return columnDataList;
    }

    public List<RecordType> getRecordList() {
        return recordList;
    }
}
