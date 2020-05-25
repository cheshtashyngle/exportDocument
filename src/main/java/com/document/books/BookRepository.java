package com.document.books;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    public List<Book> books() {
        List<Book> booksList = new ArrayList<>();
        Book book1 = new Book("Head First With Java", "Serran", "1990");
        Book book2 = new Book("Complete Reference", "Java Author", "2001");
        booksList.add(book1);
        booksList.add(book2);
        return booksList;
    }

}
