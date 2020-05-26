package com.document.movies;

import com.document.DocumentBuilder;
import com.document.DocumentService;

public class MoviesDocumentService {

    private final DocumentService<Movie> movieDocumentService;

    public MoviesDocumentService(MoviesDocumentInfo moviesDocumentInfo, DocumentBuilder documentBuilder) {
        this.movieDocumentService = new DocumentService<>(moviesDocumentInfo.getRepository(),
                moviesDocumentInfo.getDocumentDataMapper(), documentBuilder);
    }

    public String build() {
        return movieDocumentService.build();
    }
}
