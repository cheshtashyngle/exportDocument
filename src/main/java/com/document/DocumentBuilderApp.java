package com.document;

import com.document.books.*;
import com.document.movies.*;

import java.util.ArrayList;
import java.util.List;

public class DocumentBuilderApp {

    public static void main(String[] args) {
        List<SingleDocumentService> documentServices = getSingleDocumentServices();

        StringBuilder fullDocumentBuilder = new StringBuilder();
        documentServices.forEach(documentService -> fullDocumentBuilder.append(documentService.build()));

        System.out.println(fullDocumentBuilder.toString());
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
        return new DocumentBuilder();
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
