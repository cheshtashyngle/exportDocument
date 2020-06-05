package com.document.jasper;

public class ReportData<RecordType> {
    private final String reportName;
    private final GridData<RecordType> gridData;

    public ReportData(String reportName, GridData<RecordType> gridData) {
        this.reportName = reportName;
        this.gridData = gridData;
    }

    public String getReportName() {
        return reportName;
    }

    public GridData<RecordType> getGridData() {
        return gridData;
    }
}
