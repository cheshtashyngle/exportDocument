package com.document.books;

import com.document.DocumentBuilder;
import com.document.RecordMap;
import com.document.RecordsMapper;

import java.util.List;

public class BooksDocumentService {

    private final BookRepository bookRepository;
    private final RecordsMapper<Book> booksMapper;
    private final DocumentBuilder documentBuilder;

    public BooksDocumentService(BookRepository bookRepository, RecordsMapper<Book> booksMapper, DocumentBuilder documentBuilder) {
        this.bookRepository = bookRepository;
        this.booksMapper = booksMapper;
        this.documentBuilder = documentBuilder;
    }

    public String build() {
        List<Book> books = bookRepository.books();
        List<RecordMap> bookMapList = booksMapper.getRecordMapList(books);
        BooksDocumentData booksDocumentData = new BooksDocumentData(bookMapList);
        return documentBuilder.build(booksDocumentData);
    }
}
