package com.document;

import com.document.books.*;
import com.document.movies.Movie;
import com.document.movies.MovieDocumentData;
import com.document.movies.MovieRepository;
import com.document.movies.MoviesDocumentBuilder;

import java.util.List;

public class DocumentBuilderApp {

    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        BooksDocumentBuilder booksDocumentBuilder = new BooksDocumentBuilder();
        BooksMapper booksMapper = new BooksMapper();

        List<Book> books = bookRepository.books();
        List<DocumentRecordMap> booksMapList = booksMapper.getDocumentMapList(books);
        BooksDocumentData booksDocumentData = new BooksDocumentData(books, booksMapList);

        System.out.println(booksDocumentBuilder.build(booksDocumentData));

        MovieRepository movieRepository = new MovieRepository();
        MoviesDocumentBuilder moviesDocumentBuilder = new MoviesDocumentBuilder();

        List<Movie> movies = movieRepository.movies();
        MovieDocumentData movieDocumentData = new MovieDocumentData(movies);

        System.out.println(moviesDocumentBuilder.build(movieDocumentData));
    }
}
