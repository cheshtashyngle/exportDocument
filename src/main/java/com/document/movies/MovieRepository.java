package com.document.movies;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    public List<Movie> movies() {
        List<Movie> movieList = new ArrayList<>();
        Movie movie = new Movie("ABCD2", "2015", "PrabhuDeva", 8);
        movieList.add(movie);
        return movieList;
    }
}
