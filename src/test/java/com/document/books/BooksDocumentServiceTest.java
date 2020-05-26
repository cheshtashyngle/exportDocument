package com.document.books;

import com.document.DocumentBuilder;
import com.document.RecordsMapper;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BooksDocumentServiceTest {

    private final BookRepository bookRepository = new BookRepository();
    private final RecordsMapper<Book> booksMapper = new BooksMapper();
    private final DocumentBuilder documentBuilder = new DocumentBuilder();
    private final BooksDocumentService booksDocumentService = new BooksDocumentService(bookRepository, booksMapper, documentBuilder);

    @Test
    public void shouldBuildDocument() {
        String expectedDocument = "Books Document\nName\tAuthor\tYearOfPublishing\t\n" +
                "Head First With Java\tSerran\t1990\t\nComplete Reference\tJava Author\t2001\t";

        String actualDocument = booksDocumentService.build();

        assertThat(actualDocument, is(expectedDocument));
    }
}