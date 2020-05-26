package com.document.movies;

import com.document.DocumentBuilder;
import com.document.DocumentData;
import com.document.DocumentDataMapper;
import com.document.RecordsRepository;

import java.util.List;

public class MoviesDocumentService {

    private final RecordsRepository<Movie> recordsRepository;
    private final DocumentDataMapper<Movie> documentDataMapper;
    private final DocumentBuilder documentBuilder;

    public MoviesDocumentService(RecordsRepository<Movie> recordsRepository,
                                 DocumentDataMapper<Movie> documentDataMapper,
                                 DocumentBuilder documentBuilder) {
        this.recordsRepository = recordsRepository;
        this.documentDataMapper = documentDataMapper;
        this.documentBuilder = documentBuilder;
    }

    public String build() {
        List<Movie> records = recordsRepository.getRecords();
        DocumentData documentData = documentDataMapper.getDocumentData(records);
        return documentBuilder.build(documentData);
    }
}
