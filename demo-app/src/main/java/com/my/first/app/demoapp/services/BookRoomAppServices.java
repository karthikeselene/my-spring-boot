package com.my.first.app.demoapp.services;

import com.my.first.app.demoapp.controllers.BookRoomDataFields;
import com.my.first.app.demoapp.repositories.BookRoomDataRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookRoomAppServices {

    @Autowired
    BookRoomDataRepository repository;

    public String generateId(String isbn, int aisle) {
        if(isbn.startsWith("#")) {
            return isbn.substring(1)+aisle;
        }
        return isbn+aisle;
    }

    public boolean isRecordPresent(String id) {
        boolean bReturn = false;
        Optional<BookRoomDataFields> record = repository.findById(id);
        if(record.isPresent()) { bReturn = true; }
        return bReturn;
    }
    
}
