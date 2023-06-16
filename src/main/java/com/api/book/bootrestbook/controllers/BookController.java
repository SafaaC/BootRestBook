package com.api.book.bootrestbook.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping(books)
    public String getBook(){
        return "this is testing book first" ;
    }
    
}
