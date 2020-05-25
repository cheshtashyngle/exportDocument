package com.document.books;

import java.util.List;

public class BooksDocumentBuilder {

    public String build(BooksDocumentData booksData) {
        return (booksData.getDocumentName() + "\n") +
                getContent(booksData);
    }

    private String getContent(BooksDocumentData booksData) {
        return getRecordsTitlesString(booksData.getRecordsTitles()) +
                getBookRecordsString(booksData.getRecords());
    }

    private String getRecordsTitlesString(List<String> bookRecordTitles) {
        StringBuilder stringBuilder = new StringBuilder();
        bookRecordTitles.forEach(recordTitle -> {
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
}
