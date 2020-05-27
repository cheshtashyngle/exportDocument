package com.document;

import java.util.List;

public class StringDocumentBuilder implements DocumentBuilder {

    @Override
    public String build(DocumentData data) {
        return (data.getDocumentName() + "\n") +
                getContent(data);
    }

    private String getContent(DocumentData data) {
        List<String> recordTitles = data.getRecordsTitles();
        return getRecordsTitlesString(recordTitles) +
                getRecordsString(recordTitles, data.getRecordsMap());
    }

    private String getRecordsTitlesString(List<String> recordTitles) {
        StringBuilder stringBuilder = new StringBuilder();
        recordTitles.forEach(recordTitle -> stringBuilder.append(recordTitle).append("\t"));
        return stringBuilder.toString();
    }

    private String getRecordsString(List<String> recordTitles, List<RecordMap> recordMapList) {
        StringBuilder stringBuilder = new StringBuilder();
        recordMapList.forEach(recordMap -> stringBuilder.append("\n").append(getRecordString(recordTitles, recordMap)));
        return stringBuilder.toString();
    }

    private String getRecordString(List<String> recordTitles, RecordMap recordMap) {
        StringBuilder stringBuilder = new StringBuilder();
        recordTitles.forEach(recordTitle -> stringBuilder.append(recordMap.get(recordTitle)).append("\t"));
        return stringBuilder.toString();
    }
}
