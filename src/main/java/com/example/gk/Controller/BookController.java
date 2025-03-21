package com.example.gk.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gk.Entity.Book;
import com.example.gk.Service.BookService;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        List<Book> books = bookService.findAll();
        return ResponseEntity.ok(books);  
    }

    @PostMapping("/create")
    public ResponseEntity<Boolean> create(@RequestBody Book book) {
        Boolean result = bookService.save(book);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/search/keyword")
    public ResponseEntity<List<Book>> searchBykeyword(@RequestParam(required = false) String keyword){
    	return ResponseEntity.ok(bookService.searchByKeyWord(keyword));
    }
}
