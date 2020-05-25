package com.document.books;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BooksDocumentBuilderTest {

    private final BooksDocumentBuilder booksDocumentBuilder = new BooksDocumentBuilder();

    @Test
    public void shouldBuildDocument() {
        List<Book> books = new ArrayList<>();
        Book book1 = new Book("Head First With Java", "Serran", "1990");
        Book book2 = new Book("Complete Reference", "Java Author", "2001");
        books.add(book1);
        books.add(book2);

        String expectedDocument = "Books Document\nName\tAuthor\tYearOfPublishing\t\n" +
                "Head First With Java\tSerran\t1990\t\nComplete Reference\tJava Author\t2001\t";

        String actualDocument = booksDocumentBuilder.build(books);

        assertThat(actualDocument, is(expectedDocument));
    }
}