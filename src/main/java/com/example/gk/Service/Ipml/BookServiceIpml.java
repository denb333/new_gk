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

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Boolean save(Book book) {
        Book savedBook = bookRepository.save(book);
        System.out.println("Found Books: " + savedBook);
        return savedBook != null;
    }
    
    @Override
    public List<Book> searchByKeyWord(String keyword){
    	return bookRepository.findByNameContainingIgnoreCase(keyword);
    }
}
