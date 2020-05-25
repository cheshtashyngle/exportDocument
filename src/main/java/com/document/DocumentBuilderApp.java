package com.document;

import com.document.books.*;
import com.document.movies.*;

import java.util.List;

public class DocumentBuilderApp {

    public static void main(String[] args) {
        DocumentBuilder documentBuilder = new DocumentBuilder();

        BookRepository bookRepository = new BookRepository();
        BooksDocumentService booksDocumentService = new BooksDocumentService(documentBuilder);
        BooksMapper booksMapper = new BooksMapper();

        List<Book> books = bookRepository.books();
        List<RecordMap> booksMapList = booksMapper.getDocumentMapList(books);
        BooksDocumentData booksDocumentData = new BooksDocumentData(booksMapList);

        System.out.println(booksDocumentService.build(booksDocumentData));

        MovieRepository movieRepository = new MovieRepository();
        MoviesDocumentService moviesDocumentService = new MoviesDocumentService(documentBuilder);
        MoviesMapper moviesMapper = new MoviesMapper();

        List<Movie> movies = movieRepository.movies();
        List<RecordMap> moviesMapList = moviesMapper.getDocumentMapList(movies);
        MovieDocumentData movieDocumentData = new MovieDocumentData(moviesMapList);

        System.out.println(moviesDocumentService.build(movieDocumentData));
    }
}
