package com.document.jasper;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportDataMapper {

    private final ReportDataFormatProvider formatProvider;

    public ReportDataMapper(ReportDataFormatProvider formatProvider) {
        this.formatProvider = formatProvider;
    }

    public <RecordType> ReportData<RecordType> getReportData(String reportName,
                                                             Map<String, String> columnsNameMap,
                                                             List<RecordType> recordList,
                                                             Class<RecordType> recordType) {
        Map<String, Field> fieldMap = getFieldMap(recordType);
        List<ColumnData> columnDataList = getColumnData(columnsNameMap, fieldMap);

        return new ReportData<>(reportName, new GridData<>(columnDataList, recordList));
    }

    private List<ColumnData> getColumnData(Map<String, String> columnsNameMap, Map<String, Field> fieldMap) {
        return columnsNameMap.keySet().stream().map(columnId -> {
                    Class<?> columnType = fieldMap.get(columnId).getType();
                    String formatPattern = formatProvider.get(columnType);
                    return new ColumnData(columnId, columnsNameMap.get(columnId),
                            fieldMap.get(columnId).getType(), formatPattern);
            }).collect(Collectors.toList());
    }

    private <RecordType> Map<String, Field> getFieldMap(Class<RecordType> recordType) {
        Field[] fields = recordType.getDeclaredFields();
        Map<String, Field> fieldMap = new HashMap<>();
        Arrays.stream(fields).forEach(field -> fieldMap.put(field.getName(), field));
        return fieldMap;
    }
}
