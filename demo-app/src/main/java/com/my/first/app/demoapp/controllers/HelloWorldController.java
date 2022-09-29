package com.my.first.app.demoapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/helloWorld")
    public String helloWorld(){
        return "Hello!!! Amigos... Welcome to Spring Boot World";
    }
    
}
