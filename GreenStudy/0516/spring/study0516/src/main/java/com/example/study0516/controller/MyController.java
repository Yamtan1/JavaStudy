package com.example.study0516.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public String jqueryAjax() {
		return "jqueryAjax";
	}
	
	@GetMapping("/api/data")
	public @ResponseBody String get() {
		return "good";
	}
	@PostMapping("/api/post")
	public @ResponseBody String post() {
		return "gooooooooooood";
	}

}
