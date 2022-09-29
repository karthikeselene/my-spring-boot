package com.my.first.app.demoapp.controllers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="librarydb")
public class BookRoomDataFields {

    @Column(name="book_name")
    private String book_name;
    @Id
    @Column(name="id")
    private String id;
    @Column(name="isbn")
    private String isbn;
    @Column(name="aisle")
    private int aisle;
    @Column(name="author")
    private String author;

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setAisle(int aisle) {
        this.aisle = aisle;
    }

    public int getAisle() {
        return aisle;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor(){
        return author;
    }
    
}