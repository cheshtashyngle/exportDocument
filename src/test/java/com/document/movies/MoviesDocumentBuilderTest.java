package com.document.movies;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MoviesDocumentBuilderTest {

    private final MoviesDocumentBuilder moviesDocumentBuilder = new MoviesDocumentBuilder();

    @Test
    public void shouldBuildDocument() {
        List<Movie> movies = new ArrayList<>();
        Movie movie = new Movie("ABCD2", "2015", "PrabhuDeva", 8);
        movies.add(movie);

        String expectedDocument = "Movies Document\nName\tDirector\tYear\tMovie Rating\t\nABCD2\t2015\tPrabhuDeva\t8\t";

        String actualDocument = moviesDocumentBuilder.build(movies);

        assertThat(actualDocument, is(expectedDocument));
    }
}