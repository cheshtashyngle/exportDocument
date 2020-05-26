package com.document;

import java.util.List;

class FullDocumentService {

    private final List<SingleDocumentService> documentServices;

    FullDocumentService(List<SingleDocumentService> documentServices) {
        this.documentServices = documentServices;
    }

    String build() {
        StringBuilder fullDocumentBuilder = new StringBuilder();
        documentServices.forEach(documentService -> fullDocumentBuilder.append(documentService.build()));
        return fullDocumentBuilder.toString();
    }
}
