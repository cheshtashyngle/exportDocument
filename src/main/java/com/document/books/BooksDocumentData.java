package com.document.books;

import com.document.DocumentData;

import java.util.ArrayList;
import java.util.List;

public class BooksDocumentData implements DocumentData<Book> {

    private static final String BOOKS_DOCUMENT_NAME = "Books Document";

    private static final List<String> BOOKS_RECORD_TITLES = new ArrayList<String>() {{
        add("Name");
        add("Author");
        add("YearOfPublishing");
    }};

    private final List<Book> books;

    public BooksDocumentData(List<Book> books) {
        this.books = books;
    }

    @Override
    public String getDocumentName() {
        return BOOKS_DOCUMENT_NAME;
    }

    @Override
    public List<String> getRecordsTitles() {
        return BOOKS_RECORD_TITLES;
    }

    @Override
    public List<Book> getRecords() {
        return books;
    }
}
