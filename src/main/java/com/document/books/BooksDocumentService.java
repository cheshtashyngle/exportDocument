package com.document.books;

import com.document.DocumentBuilder;
import com.document.DocumentService;

public class BooksDocumentService {

    private final DocumentService<Book> bookDocumentService;

    public BooksDocumentService(BooksDocumentInfo booksDocumentInfo, DocumentBuilder documentBuilder) {
        this.bookDocumentService = new DocumentService<>(booksDocumentInfo.getRepository(),
                booksDocumentInfo.getDocumentDataMapper(), documentBuilder);
    }

    public String build() {
        return bookDocumentService.build();
    }
}
