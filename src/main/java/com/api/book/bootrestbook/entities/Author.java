package com.api.book.bootrestbook.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int aId;
    
    private String firstName;
    private String lastName;

    @OneToOne(mappedBy = "author")
    @JsonBackReference  //will not convert child field to Jsons so avoid infinite looping
    private Book book;
    
    public int getaId() {
        return aId;
    }
    public void setaId(int aId) {
        this.aId = aId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Author() {
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    
}
