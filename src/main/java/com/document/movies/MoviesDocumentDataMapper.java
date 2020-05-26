package com.document.movies;

import com.document.DocumentData;
import com.document.RecordMap;
import com.document.DocumentDataMapper;

import java.util.List;

import static com.document.movies.MoviesDocumentConstants.*;

public class MoviesDocumentDataMapper implements DocumentDataMapper<Movie> {

    @Override
    public DocumentData getDocumentData(List<Movie> records) {
        return new MovieDocumentData(getRecordMapList(records));
    }

    @Override
    public RecordMap getMap(Movie movie) {
        RecordMap map = new RecordMap();
        map.put(TITLE_NAME, movie.name);
        map.put(TITLE_DIRECTOR, movie.director);
        map.put(TITLE_YEAR, movie.year);
        map.put(TITLE_MOVIE_RATING, movie.movieRating);
        return map;
    }
}
