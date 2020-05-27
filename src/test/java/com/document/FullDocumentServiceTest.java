package com.document;

import com.document.books.BookRepository;
import com.document.books.BooksDocumentDataMapper;
import com.document.books.BooksDocumentInfo;
import com.document.books.BooksDocumentService;
import com.document.movies.MovieRepository;
import com.document.movies.MoviesDocumentDataMapper;
import com.document.movies.MoviesDocumentInfo;
import com.document.movies.MoviesDocumentService;
import com.document.stringformat.StringDocumentBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FullDocumentServiceTest {

    private FullDocumentService fullDocumentService;

    @Before
    public void setUp() {
        fullDocumentService = new FullDocumentService(getSingleDocumentServices());
    }

    @Test
    public void shouldBuildDocument() {
        String fullDocument = fullDocumentService.build();
        String expectedDocument = "Books_Document\nName\tAuthor\tYearOfPublishing\t\n" +
                "Head First With Java\tSerran\t1990\t\nComplete Reference\tJava Author\t2001\t" +
                "Movies Document\nName\tDirector\tYear\tMovie Rating\t\nABCD2\t2015\tPrabhuDeva\t8\t";

        assertThat(fullDocument, is(expectedDocument));
    }

    private static List<SingleDocumentService> getSingleDocumentServices() {
        DocumentBuilder documentBuilder = getDocumentBuilder();

        BooksDocumentService booksDocumentService = getBooksDocumentService(documentBuilder);
        MoviesDocumentService moviesDocumentService = getMoviesDocumentService(documentBuilder);

        List<SingleDocumentService> documentServices = new ArrayList<>();
        documentServices.add(booksDocumentService);
        documentServices.add(moviesDocumentService);
        return documentServices;
    }

    private static DocumentBuilder getDocumentBuilder() {
        return new StringDocumentBuilder();
    }

    private static BooksDocumentService getBooksDocumentService(DocumentBuilder documentBuilder) {
        BookRepository bookRepository = new BookRepository();
        BooksDocumentDataMapper booksDocumentDataMapper = new BooksDocumentDataMapper();
        BooksDocumentInfo booksDocumentInfo = new BooksDocumentInfo(bookRepository, booksDocumentDataMapper);

        return new BooksDocumentService(booksDocumentInfo, documentBuilder);
    }

    private static MoviesDocumentService getMoviesDocumentService(DocumentBuilder documentBuilder) {
        MovieRepository movieRepository = new MovieRepository();
        MoviesDocumentDataMapper moviesDocumentDataMapper = new MoviesDocumentDataMapper();

        MoviesDocumentInfo moviesDocumentInfo = new MoviesDocumentInfo(movieRepository, moviesDocumentDataMapper);

        return new MoviesDocumentService(moviesDocumentInfo, documentBuilder);
    }
}