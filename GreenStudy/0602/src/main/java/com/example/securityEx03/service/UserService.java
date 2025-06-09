package com.example.securityEx03.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.securityEx03.dto.UserDto;
import com.example.securityEx03.entity.User;
import com.example.securityEx03.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User regist(UserDto userDto) {
        User entity = new User();
        entity.setUsername(userDto.getUsername());
        entity.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        entity.setName(userDto.getName());

        if ("admin".equals(userDto.getUsername())) {
            entity.setRole("ROLE_ADMIN");
        } else {
            entity.setRole("ROLE_MEMBER");
        }

        log.info("Saving user: {}", entity);
        return userRepository.save(entity); // 이 줄이 필요합니다
    }
}
