package org.example.chapter07.correctv1.domain;

import jakarta.persistence.Entity;

@Entity
public class Book07Cv1 extends Item07Cv1 {
    private String author;
    private String isbn;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
