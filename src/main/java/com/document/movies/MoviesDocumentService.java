package com.document.movies;

import com.document.DocumentBuilder;
import com.document.DocumentData;
import com.document.RecordMap;

import java.util.List;

public class MoviesDocumentService {

    private final MovieRepository movieRepository;
    private final MoviesMapper moviesMapper;
    private final DocumentBuilder documentBuilder;

    public MoviesDocumentService(MovieRepository movieRepository, MoviesMapper moviesMapper, DocumentBuilder documentBuilder) {
        this.movieRepository = movieRepository;
        this.moviesMapper = moviesMapper;
        this.documentBuilder = documentBuilder;
    }

    public String build() {
        List<Movie> movies = movieRepository.movies();
        List<RecordMap> movieMapList = moviesMapper.getRecordMapList(movies);
        DocumentData data = new MovieDocumentData(movieMapList);
        return documentBuilder.build(data);
    }
}
