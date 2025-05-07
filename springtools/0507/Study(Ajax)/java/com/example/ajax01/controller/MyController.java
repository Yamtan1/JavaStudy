package com.example.ajax01.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;





@Controller //1. return 활용(1) : view를 지정한다. 
			//2. return 활용(2) : 데이터를 전송한다. -> @ResponseBody를 사용해야한다.

public class MyController {
	
	
	@RequestMapping("/") 
	public String root() {
		System.out.println("root...........");
		return "index";
	}
	
	

}
