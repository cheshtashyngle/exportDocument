package com.document.jasper;

public class ColumnData {
    private final String id;
    private final String name;
    private final Class<?> type;
    private final String formatPattern;
    private final Integer width;

    public ColumnData(String id, String name, Class<?> type, String formatPattern, int width) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.formatPattern = formatPattern;
        this.width = width;
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

    public Integer getWidth() {
        return width;
    }
}
