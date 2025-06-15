package com.example.demo2;

import com.example.demo2.entity.User;
import com.example.demo2.service.UserService;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class JpaExMain {
    public static void main(String[] args){
        UserService userService = new UserService();

        //userService.createUser("Alice", "alic@green.com",30);
        //userService.createUser("Bob", "Bob@green.com",25);
        //userService.createUser("Charlie", "Charlie@green.com",20);

        //User user = userService.findUserById(10L);

        //userService.findAllUsers();

        //userService.updateUser(1L,"ddd@aaa.com");
        /*
        List<User> list = userService.findUserByAge(25);
            for(User user1 : list){
                System.out.println(user1.getUserName() + " , " + user1.getAge());
            }
         */
        //userService.deleteUser(1L);
        userService.mergeUser();

    }
}
