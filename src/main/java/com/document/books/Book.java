package com.document.books;

import java.util.Date;

public class Book {

    String name;
    String author;
    Date dateOfPublication;

    Book(String name, String author, Date dateOfPublication) {
        this.name = name;
        this.author = author;
        this.dateOfPublication = dateOfPublication;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDateOfPublication() {
        return dateOfPublication;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDateOfPublication(Date dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }
}
