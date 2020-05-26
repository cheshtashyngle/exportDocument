package com.document.movies;

import com.document.DocumentDataMapper;
import com.document.RecordsRepository;
import com.document.books.DocumentInfo;

public class MoviesDocumentInfo implements DocumentInfo<Movie> {

    private final MovieRepository movieRepository;
    private final MoviesDocumentDataMapper moviesDocumentDataMapper;

    public MoviesDocumentInfo(MovieRepository movieRepository, MoviesDocumentDataMapper moviesDocumentDataMapper) {
        this.movieRepository = movieRepository;
        this.moviesDocumentDataMapper = moviesDocumentDataMapper;
    }

    @Override
    public RecordsRepository<Movie> getRepository() {
        return movieRepository;
    }

    @Override
    public DocumentDataMapper<Movie> getDocumentDataMapper() {
        return moviesDocumentDataMapper;
    }
}
