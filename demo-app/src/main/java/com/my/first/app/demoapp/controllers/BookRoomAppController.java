package com.my.first.app.demoapp.controllers;

import com.my.first.app.demoapp.objects.AddBookResponse;
import com.my.first.app.demoapp.objects.UpdateBookResponse;
import com.my.first.app.demoapp.repositories.BookRoomDataRepository;
import com.my.first.app.demoapp.services.BookRoomAppServices;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BookRoomAppController {

    @Autowired
    BookRoomDataRepository repo;

    @Autowired
    BookRoomAppServices services;

    @PostMapping("/addBook")
    public ResponseEntity<AddBookResponse> addBookResource(@RequestBody BookRoomDataFields lib){
        AddBookResponse response = new AddBookResponse();
        if(!services.isRecordPresent(services.generateId(lib.getIsbn(), lib.getAisle()))) {
            lib.setId(services.generateId(lib.getIsbn(), lib.getAisle()));
            repo.save(lib);
            HttpHeaders headers = new HttpHeaders();
            headers.add("uuid", services.generateId(lib.getIsbn(), lib.getAisle()));
            response.setMsg("Book is successfully added into librarydb");
            response.setId(services.generateId(lib.getIsbn(), lib.getAisle()));
            return new ResponseEntity<AddBookResponse>(response, headers, HttpStatus.CREATED);
        } else {
            response.setMsg("Book is already added into the librarydb");
            response.setId(services.generateId(lib.getIsbn(), lib.getAisle()));
            return new ResponseEntity<AddBookResponse>(response, HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/getBooks")
    public ResponseEntity<List<BookRoomDataFields>> getBooksResource() {
        List<BookRoomDataFields> respone = repo.findAll();  
        return new ResponseEntity<List<BookRoomDataFields>>(respone, HttpStatus.OK);
    }

    @GetMapping("/getBook/{id}")
    public ResponseEntity<BookRoomDataFields> getBookById(@PathVariable(name = "id") String id) {
        try {
            BookRoomDataFields response = repo.findById(id).get();
            return new ResponseEntity<BookRoomDataFields>(response, HttpStatus.OK);
        } catch (NoSuchElementException e) {            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    } 
    
    @GetMapping("/getBook")
    public ResponseEntity<List<BookRoomDataFields>> getBookByAuthor(@RequestParam(name = "authorName") String authorName) {
        List<BookRoomDataFields> response = repo.findAllByAuthor(authorName);
        return new ResponseEntity<List<BookRoomDataFields>>(response, HttpStatus.OK);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable(name = "id")String id, @RequestBody BookRoomDataFields lib) {
        UpdateBookResponse response = new UpdateBookResponse();
        if(services.isRecordPresent(id)) {
            BookRoomDataFields record = repo.findById(id).get();
            record.setAisle(lib.getAisle());
            record.setBook_name(lib.getBook_name());
            record.setAuthor(lib.getAuthor());
            repo.save(record);
            return new ResponseEntity<Object>(record, HttpStatus.OK);
        } else {
            response.setCode(404);
            response.setMessage("Book wasn't exists in the librarydb use /addBook resource to add");
            return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/deleteBook")
    public ResponseEntity<String> deleteBook(@RequestBody BookRoomDataFields lib) {
        BookRoomDataFields record = repo.findById(lib.getId()).get();
        repo.delete(record);
        return new ResponseEntity<>("Book was deleted from the librarydb", HttpStatus.OK);
    }

}