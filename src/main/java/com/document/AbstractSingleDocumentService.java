package com.document;

import com.document.books.DocumentInfo;

import java.util.List;

public abstract class AbstractSingleDocumentService<RecordType> {

    private final RecordsRepository<RecordType> recordsRepository;
    private final DocumentDataMapper<RecordType> documentDataMapper;
    private final DocumentBuilder documentBuilder;

    public AbstractSingleDocumentService(DocumentInfo<RecordType> documentInfo,
                                         DocumentBuilder documentBuilder) {
        this.recordsRepository = documentInfo.getRepository();
        this.documentDataMapper = documentInfo.getDocumentDataMapper();
        this.documentBuilder = documentBuilder;
    }

    public String build() {
        List<RecordType> records = recordsRepository.getRecords();
        DocumentData documentData = documentDataMapper.getDocumentData(records);
        return documentBuilder.build(documentData);
    }
}
