package com.document;

import java.util.List;
import java.util.stream.Collectors;

public interface DocumentDataMapper<RecordType> {

    DocumentData getDocumentData(List<RecordType> records);

    default List<RecordMap> getRecordMapList(List<RecordType> records) {
        return records.stream()
                .map(this::getMap)
                .collect(Collectors.toList());
    }

    RecordMap getMap(RecordType record);
}
