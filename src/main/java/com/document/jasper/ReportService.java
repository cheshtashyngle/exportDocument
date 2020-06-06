package com.document.jasper;

import com.document.RecordsRepository;
import freemarker.template.TemplateException;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReportService<RecordType> {

    public static final String REPORT_JRXML = "report.jrxml";
    private final RecordsRepository<RecordType> repository;
    private final ReportInfo reportInfo;
    private final ReportDataMapper mapper;
    private final FreeMarkerBuilder freeMarkerBuilder;
    private final JasperReportBuilder jasperReportBuilder;

    public ReportService(RecordsRepository<RecordType> repository,
                         ReportInfo reportInfo,
                         ReportDataMapper mapper,
                         FreeMarkerBuilder freeMarkerBuilder,
                         JasperReportBuilder jasperReportBuilder) {
        this.repository = repository;
        this.reportInfo = reportInfo;
        this.mapper = mapper;
        this.freeMarkerBuilder = freeMarkerBuilder;
        this.jasperReportBuilder = jasperReportBuilder;
    }

    public void buildReport(Map<String, String> visibleColumnsMap) throws IOException, TemplateException, JRException {
        List<RecordType> records = repository.getRecords();
        ReportData<RecordType> reportData = mapper.getReportData(reportInfo.getReportName(), visibleColumnsMap,
                reportInfo.getColumnWidthMap(), records, reportInfo.getRecordType());
        freeMarkerBuilder.build(reportData.getGridData().getColumnDataList(),
                reportInfo.getTemplateName(), REPORT_JRXML);
        jasperReportBuilder.build(reportData, REPORT_JRXML, reportInfo.getReportFileName());
    }
}
