package com.document;

import com.document.books.Book;
import com.document.books.BookRepository;
import com.document.books.BooksDocumentBuilder;

import java.util.List;

public class DocumentBuilderApp {

    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        BooksDocumentBuilder booksDocumentBuilder = new BooksDocumentBuilder();

        List<Book> books = bookRepository.books();
        System.out.println(booksDocumentBuilder.build(books));
    }
}
