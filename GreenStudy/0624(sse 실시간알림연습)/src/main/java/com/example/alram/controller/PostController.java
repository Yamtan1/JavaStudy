// PostController.java
package com.example.alram.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.alram.entity.Subscription;
import com.example.alram.entity.User;
import com.example.alram.repository.SubscriptionRepository;
import com.example.alram.repository.UserRepository;
import com.example.alram.service.NotificationService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final NotificationService notificationService;
    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;   // 글쓴이 찾기용

    @PostMapping("/post")
    public String post(@RequestParam("content") String content,
                       HttpSession session) {

        String writerName = (String) session.getAttribute("username");
        if (writerName == null) return "redirect:/";

        // ① 글 작성자 엔티티 조회
        User writer = userRepository.findByUsername(writerName);
        //   (글 저장 로직은 생략)

        // ② 글 작성자의 구독자 목록 조회
        List<Subscription> subs = subscriptionRepository.findByTarget(writer);

        // ③ 팔로워 전원에게 알림 저장 + SSE
        for (Subscription sub : subs) {
            String followerName = sub.getFollower().getUsername();
            notificationService.notifyUser(
                followerName,
                writerName + " 님이 글을 작성했습니다: " + content
            );
        }
        return "redirect:/home";
    }
}