package com.example.book0619.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.book0619.entity.Book;
import com.example.book0619.service.BookService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		List<Book> list = bookService.findBooks();
		return list;
	}
	
	@GetMapping("/search")
	public List<Book> searchBookTitle(@RequestParam("keyword")String keyword) {
		List<Book> list = bookService.findBookTitle(keyword);
		return list;
	}
	@GetMapping("/book/{id}")
	public Book getBookById(@PathVariable("id") Integer id) {
		Book book = bookService.findBookWithId(id);
		return book;
	}
	

}
