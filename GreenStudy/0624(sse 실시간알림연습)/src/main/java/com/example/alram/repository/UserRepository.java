package com.example.alram.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.alram.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	 // 사용자 이름으로 조회
	User findByUsername(String username);

	User findByUsernameAndPassword(String username, String password);

}
