package com.example.securityEx03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.securityEx03.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByUsername(String username);

}
