package com.example.alram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.alram.entity.Subscription;
import com.example.alram.entity.User;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

	/** 글 작성자를 기준으로 모든 팔로워 조회 */
	List<Subscription> findByTarget(User target);
}