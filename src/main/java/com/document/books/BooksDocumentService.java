package com.document.books;

import com.document.DocumentBuilder;
import com.document.DocumentData;
import com.document.DocumentDataMapper;

import java.util.List;

public class BooksDocumentService {

    private final BookRepository bookRepository;
    private final DocumentDataMapper<Book> booksMapper;
    private final DocumentBuilder documentBuilder;

    public BooksDocumentService(BookRepository bookRepository,
                                DocumentDataMapper<Book> booksMapper,
                                DocumentBuilder documentBuilder) {
        this.bookRepository = bookRepository;
        this.booksMapper = booksMapper;
        this.documentBuilder = documentBuilder;
    }

    public String build() {
        List<Book> books = bookRepository.getRecords();
        DocumentData documentData = booksMapper.getDocumentData(books);
        return documentBuilder.build(documentData);
    }
}
