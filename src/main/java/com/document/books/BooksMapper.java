package com.document.books;

import com.document.DocumentRecordMap;
import com.document.RecordsMapper;

import java.util.List;
import java.util.stream.Collectors;

import static com.document.books.BooksDocumentConstants.TITLE_AUTHOR;
import static com.document.books.BooksDocumentConstants.TITLE_NAME;
import static com.document.books.BooksDocumentConstants.TITLE_YEAR_OF_PUBLISHING;

public class BooksMapper implements RecordsMapper<Book> {

    @Override
    public List<DocumentRecordMap> getDocumentMapList(List<Book> books) {
        return books.stream()
                .map(this::getMap)
                .collect(Collectors.toList());
    }

    @Override
    public DocumentRecordMap getMap(Book book) {
        DocumentRecordMap map = new DocumentRecordMap();
        map.put(TITLE_NAME, book.name);
        map.put(TITLE_AUTHOR, book.author);
        map.put(TITLE_YEAR_OF_PUBLISHING, book.yearOfPublishing);
        return map;
    }
}
