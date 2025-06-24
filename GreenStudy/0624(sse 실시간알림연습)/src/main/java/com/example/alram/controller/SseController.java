package com.example.alram.controller;

import com.example.alram.service.SseService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Controller
@RequiredArgsConstructor
public class SseController {
    private final SseService sseService;

    @GetMapping(value = "/subscribe", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter subscribe(HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) throw new IllegalStateException("로그인 필요");
        return sseService.subscribe(username);
    }
}