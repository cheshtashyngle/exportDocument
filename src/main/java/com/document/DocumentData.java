package com.document;

import java.util.List;

public interface DocumentData<RecordType> {
    String getDocumentName();

    List<String> getRecordsTitles();

    List<RecordType> getRecords();

    List<DocumentRecordMap> getRecordsMap();
}
