package com.document.books;

import com.document.DocumentBuilder;
import com.document.DocumentData;

public class BooksDocumentService {

    private final DocumentBuilder documentBuilder;

    public BooksDocumentService(DocumentBuilder documentBuilder) {
        this.documentBuilder = documentBuilder;
    }

    public String build(DocumentData data) {
        return documentBuilder.build(data);
    }
}
