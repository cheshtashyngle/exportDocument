package com.document;

import java.util.List;

public class DocumentService<RecordType> {

    private final RecordsRepository<RecordType> recordsRepository;
    private final DocumentDataMapper<RecordType> documentDataMapper;
    private final DocumentBuilder documentBuilder;

    public DocumentService(RecordsRepository<RecordType> recordsRepository,
                                DocumentDataMapper<RecordType> documentDataMapper,
                                DocumentBuilder documentBuilder) {
        this.recordsRepository = recordsRepository;
        this.documentDataMapper = documentDataMapper;
        this.documentBuilder = documentBuilder;
    }

    public String build() {
        List<RecordType> records = recordsRepository.getRecords();
        DocumentData documentData = documentDataMapper.getDocumentData(records);
        return documentBuilder.build(documentData);
    }
}
