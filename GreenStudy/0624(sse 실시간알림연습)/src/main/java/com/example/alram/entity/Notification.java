package com.example.alram.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sse_notification")
@Getter @Setter
public class Notification {

    @Id @GeneratedValue
    private Long id;

    private String username;
    private String content;

    @Column(name = "is_read", nullable = false)
    private Boolean isRead = false;            // ★ 기본값

    private LocalDateTime createdAt;
}
