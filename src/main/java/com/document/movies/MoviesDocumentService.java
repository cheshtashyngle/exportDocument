package com.document.movies;

import com.document.DocumentBuilder;
import com.document.DocumentData;

public class MoviesDocumentService {

    private final DocumentBuilder documentBuilder;

    public MoviesDocumentService(DocumentBuilder documentBuilder) {
        this.documentBuilder = documentBuilder;
    }

    public String build(DocumentData data) {
        return documentBuilder.build(data);
    }
}
