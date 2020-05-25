package com.document;

import com.document.books.Book;
import com.document.books.BookRepository;
import com.document.books.BooksDocumentBuilder;
import com.document.books.BooksDocumentData;
import com.document.movies.Movie;
import com.document.movies.MovieDocumentData;
import com.document.movies.MovieRepository;
import com.document.movies.MoviesDocumentBuilder;

import java.util.List;

public class DocumentBuilderApp {

    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        BooksDocumentBuilder booksDocumentBuilder = new BooksDocumentBuilder();

        List<Book> books = bookRepository.books();
        BooksDocumentData booksDocumentData = new BooksDocumentData(books);

        System.out.println(booksDocumentBuilder.build(booksDocumentData));

        MovieRepository movieRepository = new MovieRepository();
        MoviesDocumentBuilder moviesDocumentBuilder = new MoviesDocumentBuilder();

        List<Movie> movies = movieRepository.movies();
        MovieDocumentData movieDocumentData = new MovieDocumentData(movies);

        System.out.println(moviesDocumentBuilder.build(movieDocumentData));
    }
}
