package com.example.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_user2")
@Data
public class MemberEntity {
	
	@Id
    private String username;
    private String password;
    private String name;
    private String role; // "ROLE_MEMBER" 또는 "ROLE_ADMIN"


}
