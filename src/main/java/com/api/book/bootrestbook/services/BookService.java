package com.api.book.bootrestbook.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;
@Component
public class BookService {
    
    @Autowired
   private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        List<Book> list= (List<Book>) this.bookRepository.findAll();
        return list;
    }

    
    public Book getBookById(int id){
        
        Book book=bookRepository.findById(id);
        return book;
    }

    //adding book
    public Book addBook(Book b){
        bookRepository.save(b);
        return b;
    }

    //delete book
    public void deleteBook(int bid){
       
        bookRepository.deleteById(bid);
    }

    //update book
    public void updateBook(Book book, int bid){
        book.setId(bid);
        bookRepository.save(book);
    }
}
