package com.example.alram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.alram.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findAllByOrderByCreatedAtDesc();



}
