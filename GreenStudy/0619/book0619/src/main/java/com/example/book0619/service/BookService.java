package com.example.book0619.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book0619.entity.Book;
import com.example.book0619.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;

	public List<Book> findBooks(){
		List<Book> list = bookRepository.findAll();
		return list;
	}
	public List<Book> findBookTitle(String keyword) {
		List<Book> list = bookRepository.findByTitleContaining(keyword);
		return list;
	}
	public Book findBookWithId(Integer id) {
		Book book = bookRepository.findById(id).orElse(null);
		return book;
	}
}
