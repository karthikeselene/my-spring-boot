package com.my.first.app.demoapp.repositories;

import com.my.first.app.demoapp.controllers.BookRoomDataFields;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class BookRoomDataRepositoryImpl implements BookRoomDataRepositoryCustom {

    @Lazy
    @Autowired
    BookRoomDataRepository repo;

    @Override
    public List<BookRoomDataFields> findAllByAuthor(String authorName) {
        List<BookRoomDataFields> records = repo.findAll();
        List<BookRoomDataFields> filter_author = new ArrayList<BookRoomDataFields>();
        for (int i = 0; i < records.size(); i++) {
            if(records.get(i).getAuthor().equals(authorName)) {
                filter_author.add(records.get(i));
            }
        }
        return filter_author;
    }
    
}
