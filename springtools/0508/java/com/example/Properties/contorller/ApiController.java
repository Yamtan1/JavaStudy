package com.example.Properties.contorller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Properties.service.Api;

@Controller
public class ApiController {

	@RequestMapping("/")
	public String root() {
		System.out.println("root.......");
		return "index";
	}
	
	@GetMapping("/test")
	public @ResponseBody String data() throws IOException {
		Api a = new Api();
		String data = a.data();
		return data;
	}
}
