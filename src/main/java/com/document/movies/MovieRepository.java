package com.document.movies;

import com.document.RecordsRepository;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository implements RecordsRepository<Movie> {

    @Override
    public List<Movie> getRecords() {
        List<Movie> movieList = new ArrayList<>();
        Movie movie = new Movie("ABCD2", "2015", "PrabhuDeva", 8);
        movieList.add(movie);
        return movieList;
    }
}
