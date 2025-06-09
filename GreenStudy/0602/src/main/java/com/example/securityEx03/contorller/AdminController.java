package com.example.securityEx03.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {

   
   @GetMapping("/dashboard")
   public String dashboard() {
      return "/admin/dashboard";
   }
}
