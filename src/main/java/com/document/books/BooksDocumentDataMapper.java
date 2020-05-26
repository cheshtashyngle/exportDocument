package com.document.books;

import com.document.DocumentData;
import com.document.RecordMap;
import com.document.DocumentDataMapper;

import java.util.List;

import static com.document.books.BooksDocumentConstants.TITLE_AUTHOR;
import static com.document.books.BooksDocumentConstants.TITLE_NAME;
import static com.document.books.BooksDocumentConstants.TITLE_YEAR_OF_PUBLISHING;

public class BooksDocumentDataMapper implements DocumentDataMapper<Book> {

    @Override
    public DocumentData getDocumentData(List<Book> books) {
        return new BooksDocumentData(getRecordMapList(books));
    }

    @Override
    public RecordMap getMap(Book book) {
        RecordMap map = new RecordMap();
        map.put(TITLE_NAME, book.name);
        map.put(TITLE_AUTHOR, book.author);
        map.put(TITLE_YEAR_OF_PUBLISHING, book.yearOfPublishing);
        return map;
    }
}
