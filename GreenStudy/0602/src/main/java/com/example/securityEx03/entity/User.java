package com.example.securityEx03.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_user2")
@Data
public class User {
	
	@Id
	private String username;
	private String password;
	private String name;
	private String role;
}
