package com.my.first.app.demoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAppApplication {

	// @Autowired
	// BookRoomDataRepository lib_repo;
 
	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
	}

	// @Override
	// public void run(String... args) throws Exception {
	// 	BookRoomDataFields lib = lib_repo.findById("fdsefr343").get();
	// 	System.out.println(lib.getBook_name());
	// 	System.out.println(lib.getId());
	// 	System.out.println(lib.getIsbn());
	// 	System.out.println(lib.getAisle());
	// 	System.out.println(lib.getAuthor());
	// 	List<BookRoomDataFields> allRecords = lib_repo.findAll();
	// 	for (BookRoomDataFields record : allRecords) {
	// 		System.out.println(record.getBook_name());			
	// 	}
	// }	
	
}