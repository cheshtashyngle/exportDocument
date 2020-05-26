package com.document;

import com.document.books.*;
import com.document.movies.*;

public class DocumentBuilderApp {

    public static void main(String[] args) {
        DocumentBuilder documentBuilder = new DocumentBuilder();

        BookRepository bookRepository = new BookRepository();
        BooksMapper booksMapper = new BooksMapper();

        BooksDocumentService booksDocumentService = new BooksDocumentService(bookRepository, booksMapper, documentBuilder);

        System.out.println(booksDocumentService.build());

        MovieRepository movieRepository = new MovieRepository();
        MoviesMapper moviesMapper = new MoviesMapper();

        MoviesDocumentService moviesDocumentService = new MoviesDocumentService(movieRepository, moviesMapper, documentBuilder);

        System.out.println(moviesDocumentService.build());
    }
}
