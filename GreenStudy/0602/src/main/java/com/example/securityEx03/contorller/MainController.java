package com.example.securityEx03.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.securityEx03.dto.UserDto;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String root() {
		
		return "index";
	}
	
}
