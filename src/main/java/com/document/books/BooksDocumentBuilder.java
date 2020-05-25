package com.document.books;

import java.util.ArrayList;
import java.util.List;

public class BooksDocumentBuilder {

    private static final String HEADING = "Books Document";

    public String build(List<Book> books) {
        return (HEADING + "\n") +
                getContent(books);
    }

    private String getContent(List<Book> books) {
        return getRecordsTitlesString() +
                getBookRecordsString(books);
    }

    private String getRecordsTitlesString() {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> recordTitles = getRecordsTitles();
        recordTitles.forEach(recordTitle -> {
            stringBuilder.append(recordTitle).append("\t");
        });
        return stringBuilder.toString();
    }

    private String getBookRecordsString(List<Book> books) {
        StringBuilder stringBuilder = new StringBuilder();
        books.forEach(book -> stringBuilder.append("\n").append(getBookRecord(book)));
        return stringBuilder.toString();
    }

    private String getBookRecord(Book book) {
        return book.name + "\t" +
                book.author + "\t" +
                book.yearOfPublishing + "\t";
    }

    private List<String> getRecordsTitles() {
        List<String> recordTitles = new ArrayList<>();
        recordTitles.add("Name");
        recordTitles.add("Author");
        recordTitles.add("YearOfPublishing");
        return recordTitles;
    }
}
