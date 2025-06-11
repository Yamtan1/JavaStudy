package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String root(Model model){
        System.out.println("root");
        model.addAttribute("hello", "안녕하세요!");
        return "index";
    }
}
