package com.document.movies;

import com.document.RecordMap;
import com.document.RecordsMapper;

import static com.document.movies.MoviesDocumentConstants.*;

public class MoviesMapper implements RecordsMapper<Movie> {

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
