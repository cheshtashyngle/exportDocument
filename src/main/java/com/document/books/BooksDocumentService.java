package com.document.books;

import com.document.DocumentService;

public class BooksDocumentService {

    private final DocumentService<Book> bookDocumentService;

    public BooksDocumentService(DocumentService<Book> bookDocumentService) {
        this.bookDocumentService = bookDocumentService;
    }

    public String build() {
        return bookDocumentService.build();
    }
}
