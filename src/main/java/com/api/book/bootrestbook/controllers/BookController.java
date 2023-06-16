package com.api.book.bootrestbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

    @RequestMapping(value="/books", method = RequestMethod.GET)
    @ResponseBody
    public String getBook(){
        return "this is testing book first" ;
    }
    
}
