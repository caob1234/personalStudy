package org.cb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloWorld {
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    @ResponseBody
    public String info(){
        return "Hello world!";
    }
}
