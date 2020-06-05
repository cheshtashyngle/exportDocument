package com.document.jasper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReportDataFormatProvider {

    private final static Map<Class<?>, String> formatPatternMap = new HashMap<Class<?>, String>() {{
        put(Date.class, "ddmmyy");
    }};

    public String get(Class<?> dataType) {
        return formatPatternMap.getOrDefault(dataType, null);
    }
}
