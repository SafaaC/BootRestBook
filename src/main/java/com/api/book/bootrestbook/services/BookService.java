package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;
@Component
public class BookService {
    
    //Fake Service

    private static List<Book> list= new ArrayList<Book>();

    static{
        list.add(new Book(2, "SQL", "maryam") );
        list.add(new Book(3, "Python", "Ibrahim") );
        list.add(new Book(4, "WEB", "Saara") );
    }

    public List<Book> getAllBooks(){
        return list;
    }
    public Book getBookById(int id){
        
        for (Book book : list) {
            if(book.getId()==id){
                return book;
            }
            
        }
        return null;
    }

    //adding book
    public Book addBook(Book b){
        list.add(b);
        return b;
    }
}
