package com.document.jasper;

import com.document.books.Book;
import freemarker.template.TemplateException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.sf.jasperreports.engine.JasperCompileManager.compileReport;
import static net.sf.jasperreports.engine.JasperFillManager.fillReport;

public class JasperBookReportBuilder {

    private static final String REPORT_TEMPLATE = "/jasper/book.jrxml";
    private static final String REPORT_TITLE = "reportTitle";

    private final JRXlsxExporter exporter;
    private final BookJRXMLBuilder bookJRXMLBuilder;

    public JasperBookReportBuilder(JRXlsxExporter exporter, BookJRXMLBuilder bookJRXMLBuilder) {
        this.exporter = exporter;
        this.bookJRXMLBuilder = bookJRXMLBuilder;
    }

    public String build(ReportData<Book> data, String fileName) {
        try {
            JasperReport jasperReport = compileTemplate(data.getGridData().getColumnDataList());
            JasperPrint jasperPrint = populateData(jasperReport, data);
            exportReport(jasperPrint, fileName + ".xlsx");
            return jasperPrint.toString();
        } catch (JRException | IOException | TemplateException exception) {
            return exception.getLocalizedMessage();
        }
    }

    private JasperReport compileTemplate(List<ColumnData> columnDataList) throws JRException,
            IOException, TemplateException {
        bookJRXMLBuilder.build(columnDataList);
        InputStream reportStream = getClass().getResourceAsStream(REPORT_TEMPLATE);
        return compileReport(reportStream);
    }

    private JasperPrint populateData(JasperReport report, ReportData<Book> data) throws JRException {
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
