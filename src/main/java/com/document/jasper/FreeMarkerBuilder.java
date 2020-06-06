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

public class FreeMarkerBuilder {

    private static final String OUTPUT_PATH = "src/main/resources/";
    private static final String COLUMN_DATA_LIST_KEY = "columnDataList";
    public static final String FTL = "ftl";

    private final Configuration configuration;

    public FreeMarkerBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public void build(List<ColumnData> columnDataList, String templateFileName, String outputFileName)
            throws IOException, TemplateException {
        FileWriter fileWriter = new FileWriter(new File(OUTPUT_PATH + outputFileName));

        Template template = configuration.getTemplate(templateFileName + "." + FTL);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put(COLUMN_DATA_LIST_KEY, columnDataList);

        template.process(parameters, fileWriter);
    }
}
