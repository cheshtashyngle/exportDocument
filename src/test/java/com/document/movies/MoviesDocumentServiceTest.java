package com.document.movies;

import com.document.DocumentBuilder;
import com.document.DocumentDataMapper;
import com.document.DocumentService;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MoviesDocumentServiceTest {

    private final MovieRepository movieRepository = new MovieRepository();
    private final DocumentDataMapper<Movie> moviesMapper = new MoviesDocumentDataMapper();
    private final DocumentBuilder documentBuilder = new DocumentBuilder();
    private final DocumentService<Movie> documentService = new DocumentService<>(movieRepository,
            moviesMapper, documentBuilder);
    private final MoviesDocumentService moviesDocumentService = new MoviesDocumentService(documentService);

    @Test
    public void shouldBuildDocument() {
        String expectedDocument = "Movies Document\nName\tDirector\tYear\tMovie Rating\t\nABCD2\t2015\tPrabhuDeva\t8\t";

        String actualDocument = moviesDocumentService.build();

        assertThat(actualDocument, is(expectedDocument));
    }
}