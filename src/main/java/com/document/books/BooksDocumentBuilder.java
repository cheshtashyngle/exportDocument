package com.document.books;

import com.document.DocumentData;

import java.util.List;

public class BooksDocumentBuilder {

    public String build(DocumentData<Book> data) {
        return (data.getDocumentName() + "\n") +
                getContent(data);
    }

    private String getContent(DocumentData<Book> data) {
        return getRecordsTitlesString(data.getRecordsTitles()) +
                getRecordsString(data.getRecords());
    }

    private String getRecordsTitlesString(List<String> recordTitles) {
        StringBuilder stringBuilder = new StringBuilder();
        recordTitles.forEach(recordTitle -> stringBuilder.append(recordTitle).append("\t"));
        return stringBuilder.toString();
    }

    private String getRecordsString(List<Book> items) {
        StringBuilder stringBuilder = new StringBuilder();
        items.forEach(item -> stringBuilder.append("\n").append(getBookRecord(item)));
        return stringBuilder.toString();
    }

    private String getBookRecord(Book book) {
        return book.name + "\t" +
                book.author + "\t" +
                book.yearOfPublishing + "\t";
    }
}
