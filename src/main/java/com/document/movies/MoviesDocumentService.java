package com.document.movies;

import com.document.DocumentService;

public class MoviesDocumentService {

    private final DocumentService<Movie> movieDocumentService;

    public MoviesDocumentService(DocumentService<Movie> movieDocumentService) {
        this.movieDocumentService = movieDocumentService;
    }

    public String build() {
        return movieDocumentService.build();
    }
}
