package com.example.book0619.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book0619.dto.User2Dto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class LoginController {
	
	private final List<User2Dto> users = Arrays.asList(
			new User2Dto("testuser", "1234"),
			new User2Dto("admin", "admin123")
			);
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User2Dto loginRequest){
		System.out.println("loginRequeste : " + loginRequest );
		for(User2Dto user : users) {
			if(user.getUsername().equals(loginRequest.getUsername()) &&
					user.getPassword().equals(loginRequest.getPassword())) {
				return ResponseEntity.ok(Map.of("message", "success", "username", user.getUsername()));
			}
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message","Invalid credent"));
	}
}
