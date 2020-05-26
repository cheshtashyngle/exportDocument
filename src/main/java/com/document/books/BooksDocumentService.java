package com.document.books;

import com.document.DocumentBuilder;
import com.document.RecordMap;

import java.util.List;

public class BooksDocumentService {

    private final BookRepository bookRepository;
    private final BooksMapper booksMapper;
    private final DocumentBuilder documentBuilder;

    public BooksDocumentService(BookRepository bookRepository, BooksMapper booksMapper, DocumentBuilder documentBuilder) {
        this.bookRepository = bookRepository;
        this.booksMapper = booksMapper;
        this.documentBuilder = documentBuilder;
    }

    public String build() {
        List<Book> books = bookRepository.books();
        List<RecordMap> bookMapList = booksMapper.getDocumentMapList(books);
        BooksDocumentData booksDocumentData = new BooksDocumentData(bookMapList);
        return documentBuilder.build(booksDocumentData);
    }
}
