package com.example.book0619.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book0619.dto.UserDto;
@CrossOrigin("*")
@RestController
@RequestMapping("/basic")
public class FlutterApiController {
	
	@GetMapping("/user")
	public UserDto getUser() {
		UserDto user = new UserDto("James Dean", 46, "Hello~");
		return user;
	}

}
