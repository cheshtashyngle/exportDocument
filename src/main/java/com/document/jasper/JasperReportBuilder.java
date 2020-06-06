package com.document.jasper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static net.sf.jasperreports.engine.JasperCompileManager.compileReport;
import static net.sf.jasperreports.engine.JasperFillManager.fillReport;

public class JasperReportBuilder {

    private static final String REPORT_TITLE = "reportTitle";
    private static final String XLSX = "xlsx";

    private final JRXlsxExporter exporter;

    public JasperReportBuilder(JRXlsxExporter exporter) {
        this.exporter = exporter;
    }

    public <RecordType> void build(ReportData<RecordType> data, String templateFileName, String outputFileName)
            throws JRException{
        JasperReport jasperReport = compileTemplate(templateFileName);
        JasperPrint jasperPrint = populateData(jasperReport, data);
        exportReport(jasperPrint, outputFileName + "." + XLSX);
    }

    private JasperReport compileTemplate(String templateFile) throws JRException {
        InputStream reportStream = getClass().getResourceAsStream("/" + templateFile);
        return compileReport(reportStream);
    }

    private <RecordType> JasperPrint populateData(JasperReport report, ReportData<RecordType> data) throws JRException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(REPORT_TITLE, data.getReportName());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data.getGridData().getRecordList());

        return fillReport(report, parameters, dataSource);
    }

    private void exportReport(JasperPrint jasperPrint, String filename) throws JRException {
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(filename));
        exporter.exportReport();
    }
}
