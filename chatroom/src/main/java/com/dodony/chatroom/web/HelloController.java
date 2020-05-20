package com.dodony.chatroom.web;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Index!!";
    }


    @RequestMapping("/hello")
    public String hello(String name) {
        return "hello!"+name;
    }

    
}
