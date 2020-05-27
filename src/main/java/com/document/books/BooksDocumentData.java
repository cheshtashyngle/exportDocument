package com.document.books;

import com.document.DocumentData;
import com.document.RecordMap;

import java.util.ArrayList;
import java.util.List;

import static com.document.books.BooksDocumentConstants.*;

public class BooksDocumentData implements DocumentData {

    private static final List<String> BOOKS_RECORD_TITLES = new ArrayList<String>() {{
        add(TITLE_NAME);
        add(TITLE_AUTHOR);
        add(TITLE_YEAR_OF_PUBLISHING);
    }};

    private final List<RecordMap> booksMap;

    BooksDocumentData(List<RecordMap> booksMap) {
        this.booksMap = booksMap;
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
    public List<RecordMap> getRecordMapsList() {
        return booksMap;
    }
}
