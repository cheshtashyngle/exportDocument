package com.document.movies;

import com.document.DocumentBuilder;
import com.document.DocumentData;

public class MoviesDocumentBuilder {

    private final DocumentBuilder documentBuilder;

    public MoviesDocumentBuilder(DocumentBuilder documentBuilder) {
        this.documentBuilder = documentBuilder;
    }

    public String build(DocumentData data) {
        return documentBuilder.build(data);
    }
}
