package com.document;

import com.document.books.*;
import com.document.movies.*;

import java.util.List;

public class DocumentBuilderApp {

    public static void main(String[] args) {
        DocumentBuilder documentBuilder = new DocumentBuilder();

        BookRepository bookRepository = new BookRepository();
        BooksMapper booksMapper = new BooksMapper();

        BooksDocumentService booksDocumentService = new BooksDocumentService(bookRepository, booksMapper, documentBuilder);

        System.out.println(booksDocumentService.build());

        MovieRepository movieRepository = new MovieRepository();
        MoviesDocumentService moviesDocumentService = new MoviesDocumentService(documentBuilder);
        MoviesMapper moviesMapper = new MoviesMapper();

        List<Movie> movies = movieRepository.movies();
        List<RecordMap> moviesMapList = moviesMapper.getDocumentMapList(movies);
        MovieDocumentData movieDocumentData = new MovieDocumentData(moviesMapList);

        System.out.println(moviesDocumentService.build(movieDocumentData));
    }
}
