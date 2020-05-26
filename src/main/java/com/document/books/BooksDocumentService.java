package com.document.books;

import com.document.DocumentBuilder;
import com.document.AbstractSingleDocumentService;

public class BooksDocumentService extends AbstractSingleDocumentService<Book> {

    public BooksDocumentService(BooksDocumentInfo documentInfo, DocumentBuilder documentBuilder) {
        super(documentInfo, documentBuilder);
    }
}
