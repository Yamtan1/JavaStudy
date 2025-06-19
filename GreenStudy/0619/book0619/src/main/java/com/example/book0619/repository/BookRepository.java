package com.example.book0619.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book0619.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	List<Book> findByTitleContaining(String keyword);

}
