package com.document;

import java.util.List;
import java.util.stream.Collectors;

public interface RecordsMapper<RecordType> {

    default List<RecordMap> getDocumentMapList(List<RecordType> records) {
        return records.stream()
                .map(this::getMap)
                .collect(Collectors.toList());
    }

    RecordMap getMap(RecordType record);
}
