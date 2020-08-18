package org.cb.web.controller;

import org.cb.po.Person;
import org.cb.po.Sex;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HeapController {
    List<Person> list=new ArrayList<Person>();
    @GetMapping("/heap")
    public String heap() throws Exception{
        while(true){
            list.add(new Person());
            list.add(new Sex(1));
            Thread.sleep(1);
        }
    }
}
