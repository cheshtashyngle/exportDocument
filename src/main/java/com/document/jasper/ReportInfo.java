package com.document.jasper;

import java.util.Map;

public class ReportInfo {
    private final String reportName;
    private final Map<String, Integer> columnWidthMap;
    private final Class<?> recordType;
    private final String templateName;
    private final String reportFileName;

    public ReportInfo(String reportName, Map<String, Integer> columnWidthMap,
                      Class<?> recordType, String templateName, String reportFileName) {
        this.reportName = reportName;
        this.columnWidthMap = columnWidthMap;
        this.recordType = recordType;
        this.templateName = templateName;
        this.reportFileName = reportFileName;
    }

    public String getReportName() {
        return reportName;
    }

    public Map<String, Integer> getColumnWidthMap() {
        return columnWidthMap;
    }

    public Class<?> getRecordType() {
        return recordType;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getReportFileName() {
        return reportFileName;
    }
}
