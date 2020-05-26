package com.document.books;

import com.document.DocumentBuilder;
import com.document.DocumentDataMapper;
import com.document.DocumentService;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BooksDocumentServiceTest {

    private final BookRepository bookRepository = new BookRepository();
    private final DocumentDataMapper<Book> booksMapper = new BooksDocumentDataMapper();
    private final DocumentBuilder documentBuilder = new DocumentBuilder();
    private final DocumentService<Book> documentService = new DocumentService<>(bookRepository,
            booksMapper, documentBuilder);
    private final BooksDocumentService booksDocumentService = new BooksDocumentService(documentService);

    @Test
    public void shouldBuildDocument() {
        String expectedDocument = "Books Document\nName\tAuthor\tYearOfPublishing\t\n" +
                "Head First With Java\tSerran\t1990\t\nComplete Reference\tJava Author\t2001\t";

        String actualDocument = booksDocumentService.build();

        assertThat(actualDocument, is(expectedDocument));
    }
}