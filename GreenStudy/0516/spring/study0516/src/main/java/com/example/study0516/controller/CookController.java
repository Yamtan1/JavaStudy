package com.example.study0516.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@CrossOrigin("*")
@Controller
public class CookController {
		
	
	@GetMapping("/cook/maindish")
	public @ResponseBody String maindish() {
		System.out.println("maindish...");
		return "메인요리가 나옵니다";
	}

}
