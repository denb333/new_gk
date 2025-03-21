package com.example.gk.Service;

import java.util.List;

import com.example.gk.Entity.Book;





public interface BookService {

	Boolean save(Book Book);

	List<Book> findAll();

	List<Book> searchByKeyWord(String keyword);

}
