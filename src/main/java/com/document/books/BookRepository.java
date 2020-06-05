package com.document.books;

import com.document.RecordsRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements RecordsRepository<Book> {

    @Override
    public List<Book> getRecords() {
        List<Book> booksList = new ArrayList<>();
        Book book1 = new Book("Head First With Java", "Serran", Date.valueOf("2019-11-20"));
        Book book2 = new Book("Complete Reference", "Java Author", Date.valueOf("2010-10-24"));
        booksList.add(book1);
        booksList.add(book2);
        return booksList;
    }

}
