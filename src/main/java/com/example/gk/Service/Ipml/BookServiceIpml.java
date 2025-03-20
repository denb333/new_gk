package com.example.gk.Service.Ipml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gk.Entity.Book;
import com.example.gk.Repository.BookRepository;
import com.example.gk.Service.BookService;




@Service
public class BookServiceIpml implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceIpml(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> findAll() {
     
        return bookRepository.findAll();
    }

  
    public Boolean save(Book Book) {
        Book savedBook = bookRepository.save(Book);
        if (savedBook != null) {
            return true;
        }
        return false;
    }
}