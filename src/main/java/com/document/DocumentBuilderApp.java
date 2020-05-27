package com.document;

import com.document.books.*;
import com.document.movies.*;
import com.document.stringformat.StringDocumentBuilder;

import java.util.ArrayList;
import java.util.List;

public class DocumentBuilderApp {

    public static void main(String[] args) {
        FullDocumentService fullDocumentService = getFullDocumentService();
        System.out.println(fullDocumentService.build());
    }

    private static FullDocumentService getFullDocumentService() {
        List<SingleDocumentService> documentServices = getSingleDocumentServices();

        return new FullDocumentService(documentServices);
    }

    private static List<SingleDocumentService> getSingleDocumentServices() {
        StringDocumentBuilder documentBuilder = getDocumentBuilder();

        BooksDocumentService booksDocumentService = getBooksDocumentService(documentBuilder);
        MoviesDocumentService moviesDocumentService = getMoviesDocumentService(documentBuilder);

        List<SingleDocumentService> documentServices = new ArrayList<>();
        documentServices.add(booksDocumentService);
        documentServices.add(moviesDocumentService);
        return documentServices;
    }

    private static StringDocumentBuilder getDocumentBuilder() {
        return new StringDocumentBuilder();
    }

    private static BooksDocumentService getBooksDocumentService(StringDocumentBuilder documentBuilder) {
        BookRepository bookRepository = new BookRepository();
        BooksDocumentDataMapper booksDocumentDataMapper = new BooksDocumentDataMapper();
        BooksDocumentInfo booksDocumentInfo = new BooksDocumentInfo(bookRepository, booksDocumentDataMapper);

        return new BooksDocumentService(booksDocumentInfo, documentBuilder);
    }

    private static MoviesDocumentService getMoviesDocumentService(StringDocumentBuilder documentBuilder) {
        MovieRepository movieRepository = new MovieRepository();
        MoviesDocumentDataMapper moviesDocumentDataMapper = new MoviesDocumentDataMapper();

        MoviesDocumentInfo moviesDocumentInfo = new MoviesDocumentInfo(movieRepository, moviesDocumentDataMapper);

        return new MoviesDocumentService(moviesDocumentInfo, documentBuilder);
    }
}
