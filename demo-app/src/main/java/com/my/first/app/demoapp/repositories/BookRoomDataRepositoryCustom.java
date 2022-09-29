package com.my.first.app.demoapp.repositories;

import com.my.first.app.demoapp.controllers.BookRoomDataFields;
import java.util.List;

public interface BookRoomDataRepositoryCustom {
    List<BookRoomDataFields> findAllByAuthor(String authorName);
}