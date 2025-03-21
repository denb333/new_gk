package com.example.gk.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.gk.Entity.Book;





@Repository
public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book>{

	
	@Query("SELECT DISTINCT m FROM Book m WHERE " +
	           "LOWER(m.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
	           "LOWER(m.mota) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	    List<Book> findByNameContainingIgnoreCase(@RequestParam("keyword") String keyword);
	}

