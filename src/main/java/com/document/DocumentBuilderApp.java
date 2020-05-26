package com.document;

import com.document.books.*;
import com.document.movies.*;

public class DocumentBuilderApp {

    public static void main(String[] args) {
        DocumentBuilder documentBuilder = new DocumentBuilder();

        BookRepository bookRepository = new BookRepository();
        BooksDocumentDataMapper booksDocumentDataMapper = new BooksDocumentDataMapper();

        DocumentService<Book> bookDocumentService = new DocumentService<>(bookRepository, booksDocumentDataMapper, documentBuilder);

        BooksDocumentService booksDocumentService = new BooksDocumentService(bookDocumentService);

        System.out.println(booksDocumentService.build());

        MovieRepository movieRepository = new MovieRepository();
        MoviesDocumentDataMapper moviesDocumentDataMapper = new MoviesDocumentDataMapper();

        DocumentService<Movie> movieDocumentService = new DocumentService<>(movieRepository, moviesDocumentDataMapper, documentBuilder);

        MoviesDocumentService moviesDocumentService = new MoviesDocumentService(movieDocumentService);

        System.out.println(moviesDocumentService.build());
    }
}
