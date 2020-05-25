package com.document;

import com.document.books.*;
import com.document.movies.*;

import java.util.List;

public class DocumentBuilderApp {

    public static void main(String[] args) {
        DocumentBuilder documentBuilder = new DocumentBuilder();

        BookRepository bookRepository = new BookRepository();
        BooksDocumentBuilder booksDocumentBuilder = new BooksDocumentBuilder(documentBuilder);
        BooksMapper booksMapper = new BooksMapper();

        List<Book> books = bookRepository.books();
        List<RecordMap> booksMapList = booksMapper.getDocumentMapList(books);
        BooksDocumentData booksDocumentData = new BooksDocumentData(booksMapList);

        System.out.println(booksDocumentBuilder.build(booksDocumentData));

        MovieRepository movieRepository = new MovieRepository();
        MoviesDocumentBuilder moviesDocumentBuilder = new MoviesDocumentBuilder(documentBuilder);
        MoviesMapper moviesMapper = new MoviesMapper();

        List<Movie> movies = movieRepository.movies();
        List<RecordMap> moviesMapList = moviesMapper.getDocumentMapList(movies);
        MovieDocumentData movieDocumentData = new MovieDocumentData(moviesMapList);

        System.out.println(moviesDocumentBuilder.build(movieDocumentData));
    }
}
