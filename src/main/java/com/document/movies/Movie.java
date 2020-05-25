package com.document.movies;

public class Movie {
    final String name;
    final String director;
    final String year;
    final int movieRating;

    public Movie(String name, String director, String year, int movieRating) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.movieRating = movieRating;
    }
}
