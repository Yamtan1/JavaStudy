package com.example.mybatis02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String root() {
		return "index";
	}
		
	@GetMapping("/p1")
	public String p1() {
		return "p1";
	}
	@GetMapping("/p2")
	public String p2() {
		return "p2";
	}
}
