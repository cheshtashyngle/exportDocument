package com.document.books;

import com.document.DocumentData;

import java.util.ArrayList;
import java.util.List;

import static com.document.books.BooksDocumentConstants.*;

public class BooksDocumentData implements DocumentData<Book> {

    private static final List<String> BOOKS_RECORD_TITLES = new ArrayList<String>() {{
        add(TITLE_NAME);
        add(TITLE_AUTHOR);
        add(TITLE_YEAR_OF_PUBLISHING);
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
