package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    //delete book
    public void deleteBook(int bid){
       
        list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
    }

    //update book
    public void updateBook(Book book, int bid){
        list=list.stream().map(b->{
            if(b.getId()==bid){
                b.setAuthor(book.getAuthor());
                b.setTitle(book.getTitle());
            }
            return b;
        }).collect(Collectors.toList());

    }
}
