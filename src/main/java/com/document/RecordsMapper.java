package com.document;

import com.document.DocumentRecordMap;

import java.util.List;

public interface RecordsMapper<RecordType> {
    List<DocumentRecordMap> getDocumentMapList(List<RecordType> records);

    DocumentRecordMap getMap(RecordType record);
}
