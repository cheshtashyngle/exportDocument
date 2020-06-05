package com.document.jasper;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookJRXMLBuilder {
    private static final String REPORT_JRXML_TEMPLATE = "book.ftl";
    private static final String REPORT_JRXML= "src/main/resources/jasper/book.jrxml";
    public static final String COLUMN_DATA_LIST_KEY = "columnDataList";

    private final Configuration configuration;

    public BookJRXMLBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public void build(List<ColumnData> columnDataList) throws IOException, TemplateException {
        FileWriter fileWriter = new FileWriter(new File(REPORT_JRXML));

        Template template = configuration.getTemplate(REPORT_JRXML_TEMPLATE);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put(COLUMN_DATA_LIST_KEY, columnDataList);

        template.process(parameters, fileWriter);
    }
}
