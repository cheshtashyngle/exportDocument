package com.document;

import com.document.books.*;
import com.document.movies.*;

public class DocumentBuilderApp {

    public static void main(String[] args) {
        DocumentBuilder documentBuilder = new DocumentBuilder();

        BookRepository bookRepository = new BookRepository();
        BooksDocumentDataMapper booksDocumentDataMapper = new BooksDocumentDataMapper();

        BooksDocumentInfo booksDocumentInfo = new BooksDocumentInfo(bookRepository, booksDocumentDataMapper);

        BooksDocumentService booksDocumentService = new BooksDocumentService(booksDocumentInfo, documentBuilder);

        System.out.println(booksDocumentService.build());

        MovieRepository movieRepository = new MovieRepository();
        MoviesDocumentDataMapper moviesDocumentDataMapper = new MoviesDocumentDataMapper();

        MoviesDocumentInfo moviesDocumentInfo = new MoviesDocumentInfo(movieRepository, moviesDocumentDataMapper);

        MoviesDocumentService moviesDocumentService = new MoviesDocumentService(moviesDocumentInfo, documentBuilder);

        System.out.println(moviesDocumentService.build());
    }
}
