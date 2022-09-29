package com.my.first.app.demoapp.controllers;

import com.my.first.app.demoapp.objects.Greetings;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @Autowired
    Greetings greetings;

    AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greetings greeting(@RequestParam(value = "name") String name) {
        greetings.setId(counter.incrementAndGet());
        greetings.setContent("Hey!!! I am learning Spring Boot Concept from "+name);
        return greetings;
    }
    
}
