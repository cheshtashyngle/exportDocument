package com.document.books;

import java.util.ArrayList;
import java.util.List;

public class BooksDocumentData {

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

    String getDocumentName() {
        return BOOKS_DOCUMENT_NAME;
    }

    List<String> getRecordsTitles() {
        return BOOKS_RECORD_TITLES;
    }

    List<Book> getRecords() {
        return books;
    }
}
