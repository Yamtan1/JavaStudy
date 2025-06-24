package com.example.alram.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SSE_SUBSCRIPTION")
@Getter @Setter
@NoArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUB_SEQ")
    @SequenceGenerator(name="SUB_SEQ", sequenceName="ISEQ$$_73630" /* DB에 이미 있는 시퀀스 */, allocationSize=1)
    private Long id;

    // 글을 받는 쪽 = FOLLOWER
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FOLLOWER_ID")
    private User follower;

    // 글을 쓰는 쪽 = TARGET
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TARGET_ID")
    private User target;
}
