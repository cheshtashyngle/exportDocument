package com.document.movies;

import com.document.DocumentBuilder;
import com.document.AbstractSingleDocumentService;

public class MoviesDocumentService extends AbstractSingleDocumentService<Movie> {

    public MoviesDocumentService(MoviesDocumentInfo documentInfo, DocumentBuilder documentBuilder) {
        super(documentInfo, documentBuilder);
    }
}
