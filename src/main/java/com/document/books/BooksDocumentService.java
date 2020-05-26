package com.document.books;

import com.document.DocumentBuilder;
import com.document.DocumentData;
import com.document.DocumentDataMapper;
import com.document.RecordsRepository;

import java.util.List;

public class BooksDocumentService {

    private final RecordsRepository<Book> recordsRepository;
    private final DocumentDataMapper<Book> documentDataMapper;
    private final DocumentBuilder documentBuilder;

    public BooksDocumentService(RecordsRepository<Book> recordsRepository,
                                DocumentDataMapper<Book> documentDataMapper,
                                DocumentBuilder documentBuilder) {
        this.recordsRepository = recordsRepository;
        this.documentDataMapper = documentDataMapper;
        this.documentBuilder = documentBuilder;
    }

    public String build() {
        List<Book> records = recordsRepository.getRecords();
        DocumentData documentData = documentDataMapper.getDocumentData(records);
        return documentBuilder.build(documentData);
    }
}
