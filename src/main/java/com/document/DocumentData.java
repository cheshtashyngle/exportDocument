package com.document;

import java.util.List;

public interface DocumentData<T> {
    String getDocumentName();

    List<String> getRecordsTitles();

    List<T> getRecords();
}
