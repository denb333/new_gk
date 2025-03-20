package com.example.gk.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gk.Entity.Book;
import com.example.gk.Service.BookService;


@RestController
@RequestMapping("/api/v1/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping()
	public ResponseEntity<Object>  findAll(){
		return ResponseEntity.ok(bookService);
	}
	
	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Boolean> create(@RequestBody Book book) {
	    Boolean result = bookService.save(book);
	    return ResponseEntity.ok(result);
	}

}
