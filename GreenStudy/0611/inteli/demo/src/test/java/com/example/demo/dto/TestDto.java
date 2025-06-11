package com.example.demo.dto;

import org.junit.jupiter.api.Test;

public class TestDto {

    @Test
    void testUserDto(){
        UserDto user = new UserDto();
        user.setName("홍길동");
        user.setPassword("1234");
        user.setUsername("hong");
    }

}
