package com.example.jwt0619.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String root() {
		return "login";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
}
