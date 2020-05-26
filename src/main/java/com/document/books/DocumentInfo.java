package com.document.books;

import com.document.DocumentDataMapper;
import com.document.RecordsRepository;

public interface DocumentInfo<RecordType> {
    RecordsRepository<RecordType> getRepository();

    DocumentDataMapper<RecordType> getDocumentDataMapper();
}
