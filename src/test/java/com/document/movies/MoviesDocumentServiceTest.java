package com.document.movies;

import com.document.DocumentBuilder;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MoviesDocumentServiceTest {

    private final MovieRepository movieRepository = new MovieRepository();
    private final MoviesDocumentDataMapper moviesMapper = new MoviesDocumentDataMapper();
    private final DocumentBuilder documentBuilder = new DocumentBuilder();
    private final MoviesDocumentInfo moviesDocumentInfo = new MoviesDocumentInfo(movieRepository, moviesMapper);
    private final MoviesDocumentService moviesDocumentService = new MoviesDocumentService(moviesDocumentInfo,
            documentBuilder);

    @Test
    public void shouldBuildDocument() {
        String expectedDocument = "Movies Document\nName\tDirector\tYear\tMovie Rating\t\nABCD2\t2015\tPrabhuDeva\t8\t";

        String actualDocument = moviesDocumentService.build();

        assertThat(actualDocument, is(expectedDocument));
    }
}