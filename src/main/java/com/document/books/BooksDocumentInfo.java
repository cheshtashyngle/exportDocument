package com.document.books;

import com.document.DocumentDataMapper;
import com.document.RecordsRepository;

public class BooksDocumentInfo implements DocumentInfo<Book> {

    private final BookRepository bookRepository;
    private final BooksDocumentDataMapper booksDocumentDataMapper;

    public BooksDocumentInfo(BookRepository bookRepository, BooksDocumentDataMapper booksDocumentDataMapper) {
        this.bookRepository = bookRepository;
        this.booksDocumentDataMapper = booksDocumentDataMapper;
    }

    @Override
    public RecordsRepository<Book> getRepository() {
        return bookRepository;
    }

    @Override
    public DocumentDataMapper<Book> getDocumentDataMapper() {
        return booksDocumentDataMapper;
    }
}
