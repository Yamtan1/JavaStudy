package com.example.jwtEx01.dto;

import lombok.Data;

@Data
public class LoginDto {

	private String username;
	private String password;
	private String email;
}
