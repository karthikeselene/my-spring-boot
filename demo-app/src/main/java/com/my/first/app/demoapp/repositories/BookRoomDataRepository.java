package com.my.first.app.demoapp.repositories;

import com.my.first.app.demoapp.controllers.BookRoomDataFields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRoomDataRepository extends JpaRepository<BookRoomDataFields, String>, BookRoomDataRepositoryCustom {

}