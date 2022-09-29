package com.my.first.app.demoapp.objects;

import org.springframework.stereotype.Component;

@Component
public class Greetings {

    private long id;
    private String content;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent(){
        return content;
    }
    
}