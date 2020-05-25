package com.document.books;

import com.document.DocumentData;
import com.document.DocumentRecordMap;

import java.util.List;

public class BooksDocumentBuilder {

    public String build(DocumentData<Book> data) {
        return (data.getDocumentName() + "\n") +
                getContent(data);
    }

    private String getContent(DocumentData<Book> data) {
        List<String> recordTitles = data.getRecordsTitles();
        return getRecordsTitlesString(recordTitles) +
                getRecordsString(recordTitles, data.getRecordsMap());
    }

    private String getRecordsTitlesString(List<String> recordTitles) {
        StringBuilder stringBuilder = new StringBuilder();
        recordTitles.forEach(recordTitle -> stringBuilder.append(recordTitle).append("\t"));
        return stringBuilder.toString();
    }

    private String getRecordsString(List<String> recordTitles, List<DocumentRecordMap> recordMapList) {
        StringBuilder stringBuilder = new StringBuilder();
        recordMapList.forEach(recordMap -> stringBuilder.append("\n").append(getRecordString(recordTitles, recordMap)));
        return stringBuilder.toString();
    }

    private String getRecordString(List<String> recordTitles, DocumentRecordMap recordMap) {
        StringBuilder stringBuilder = new StringBuilder();
        recordTitles.forEach(recordTitle -> stringBuilder.append(recordMap.get(recordTitle)).append("\t"));
        return stringBuilder.toString();
    }
}
