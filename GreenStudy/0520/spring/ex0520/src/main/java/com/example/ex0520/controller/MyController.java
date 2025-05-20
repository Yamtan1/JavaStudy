package com.example.ex0520.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ex0520.dao.IBoardDAO;
import com.example.ex0520.dto.BoardDTO;

import jakarta.validation.Valid;

@Controller
public class MyController {
	
	@Autowired
	IBoardDAO boarddao;
	
	void MyController(IBoardDAO dao) {
		boarddao = dao;
	}
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@PostMapping("/regboard")
	public String insert(@Valid BoardDTO board, BindingResult result) {
		if(result.hasErrors()) {
			if(result.getFieldError("title") != null) {
				System.out.println("1: " 
					+ result.getFieldError("title").getDefaultMessage());
			}
			if(result.getFieldError("writer") != null) {
				System.out.println("2: " 
					+ result.getFieldError("writer").getDefaultMessage());
			}
		}
		boarddao.insert(board);
		return "success";
	}
}
