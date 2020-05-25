package com.document.movies;

import com.document.DocumentBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MoviesDocumentServiceTest {

    private final DocumentBuilder documentBuilder = new DocumentBuilder();
    private final MoviesDocumentService moviesDocumentService = new MoviesDocumentService(documentBuilder);

    @Test
    public void shouldBuildDocument() {
        List<Movie> movies = new ArrayList<>();
        Movie movie = new Movie("ABCD2", "2015", "PrabhuDeva", 8);
        movies.add(movie);
        MoviesMapper moviesMapper = new MoviesMapper();
        MovieDocumentData movieDocumentData = new MovieDocumentData(moviesMapper.getDocumentMapList(movies));

        String expectedDocument = "Movies Document\nName\tDirector\tYear\tMovie Rating\t\nABCD2\t2015\tPrabhuDeva\t8\t";

        String actualDocument = moviesDocumentService.build(movieDocumentData);

        assertThat(actualDocument, is(expectedDocument));
    }
}