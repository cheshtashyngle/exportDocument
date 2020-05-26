package com.document.books;

import com.document.DocumentDataMapper;
import com.document.RecordsRepository;

public class BooksDocumentInfo {

    private final BookRepository bookRepository;
    private final BooksDocumentDataMapper booksDocumentDataMapper;

    public BooksDocumentInfo(BookRepository bookRepository, BooksDocumentDataMapper booksDocumentDataMapper) {
        this.bookRepository = bookRepository;
        this.booksDocumentDataMapper = booksDocumentDataMapper;
    }

    RecordsRepository<Book> getRepository() {
        return bookRepository;
    }

    DocumentDataMapper<Book> getDocumentDataMapper() {
        return booksDocumentDataMapper;
    }
}
