package com.example.alram.controller;

import com.example.alram.service.NotificationService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final NotificationService notificationService;

    @GetMapping("/")
    public String loginPage() { return "login"; }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) return "redirect:/";
        model.addAttribute("username", username);
        model.addAttribute("notifications", notificationService.getNotifications(username));
        return "home";
    }

    @GetMapping("/notifications")
    public String notifications(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) return "redirect:/";
        model.addAttribute("notifications", notificationService.getNotifications(username));
        return "notifications";
    }
}