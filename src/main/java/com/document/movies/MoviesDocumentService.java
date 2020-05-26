package com.document.movies;

import com.document.DocumentBuilder;
import com.document.DocumentData;
import com.document.DocumentDataMapper;

import java.util.List;

public class MoviesDocumentService {

    private final MovieRepository movieRepository;
    private final DocumentDataMapper<Movie> moviesMapper;
    private final DocumentBuilder documentBuilder;

    public MoviesDocumentService(MovieRepository movieRepository,
                                 DocumentDataMapper<Movie> moviesMapper,
                                 DocumentBuilder documentBuilder) {
        this.movieRepository = movieRepository;
        this.moviesMapper = moviesMapper;
        this.documentBuilder = documentBuilder;
    }

    public String build() {
        List<Movie> movies = movieRepository.movies();
        DocumentData documentData = moviesMapper.getDocumentData(movies);
        return documentBuilder.build(documentData);
    }
}
