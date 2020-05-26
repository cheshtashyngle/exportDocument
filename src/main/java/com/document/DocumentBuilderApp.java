package com.document;

import com.document.books.*;
import com.document.movies.*;

public class DocumentBuilderApp {

    public static void main(String[] args) {
        DocumentBuilder documentBuilder = new DocumentBuilder();

        BookRepository bookRepository = new BookRepository();
        BooksDocumentDataMapper booksDocumentDataMapper = new BooksDocumentDataMapper();

        BooksDocumentService booksDocumentService = new BooksDocumentService(bookRepository, booksDocumentDataMapper, documentBuilder);

        System.out.println(booksDocumentService.build());

        MovieRepository movieRepository = new MovieRepository();
        MoviesDocumentDataMapper moviesDocumentDataMapper = new MoviesDocumentDataMapper();

        MoviesDocumentService moviesDocumentService = new MoviesDocumentService(movieRepository, moviesDocumentDataMapper, documentBuilder);

        System.out.println(moviesDocumentService.build());
    }
}
