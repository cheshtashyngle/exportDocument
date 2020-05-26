package com.document.books;

import com.document.DocumentBuilder;
import com.document.SingleDocumentService;

public class BooksDocumentService extends SingleDocumentService<Book> {

    public BooksDocumentService(BooksDocumentInfo documentInfo, DocumentBuilder documentBuilder) {
        super(documentInfo, documentBuilder);
    }
}
