package com.document;

import java.util.List;

public interface DocumentData {
    String getDocumentName();

    List<String> getRecordsTitles();

    List<RecordMap> getRecordsMap();
}
