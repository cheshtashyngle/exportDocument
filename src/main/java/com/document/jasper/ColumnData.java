package com.document.jasper;

public class ColumnData {
    private final String id;
    private final String name;
    private final Class<?> type;
    private final String formatPattern;

    public ColumnData(String id, String name, Class<?> type, String formatPattern) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.formatPattern = formatPattern;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Class<?> getType() {
        return type;
    }

    public String getFormatPattern() {
        return formatPattern;
    }
}
