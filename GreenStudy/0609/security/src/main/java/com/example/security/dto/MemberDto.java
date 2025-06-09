package com.example.security.dto;

import lombok.Data;

@Data
public class MemberDto {
	
	private String username;
    private String password;
    private String name;
    private String role; // "ROLE_MEMBER" 또는 "ROLE_ADMIN"
}
