package com.my.first.app.demoapp.objects;

import org.springframework.stereotype.Component;

@Component
public class AddBookResponse {

    private String msg;
    private String id;

    public void setMsg(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
}
