package com.example.alram.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.alram.entity.Notification;
import com.example.alram.repository.NotificationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final SseService sseService;

    public void notifyUser(String username, String content) {
        Notification noti = new Notification();
        noti.setUsername(username);
        noti.setContent(content);
        noti.setCreatedAt(LocalDateTime.now());
        notificationRepository.save(noti);

        sseService.sendToUser(username, content);
    }

    public List<Notification> getNotifications(String username) {
        return notificationRepository.findTop10ByUsernameOrderByCreatedAtDesc(username);
    }
}
