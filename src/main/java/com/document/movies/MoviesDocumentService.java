package com.document.movies;

import com.document.DocumentBuilder;
import com.document.SingleDocumentService;

public class MoviesDocumentService extends SingleDocumentService<Movie> {

    public MoviesDocumentService(MoviesDocumentInfo documentInfo, DocumentBuilder documentBuilder) {
        super(documentInfo, documentBuilder);
    }
}
