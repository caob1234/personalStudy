package com.didispace.web;

import com.didispace.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private Book book;
    @RequestMapping("hello")
    public String index(){
        return "Hello world";
    }
    @RequestMapping("desc")
    public String desc(){
        return book.getDesc();
    }
}
