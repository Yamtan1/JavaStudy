package com.example.alram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.alram.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findTop10ByUsernameOrderByCreatedAtDesc(String username);
}