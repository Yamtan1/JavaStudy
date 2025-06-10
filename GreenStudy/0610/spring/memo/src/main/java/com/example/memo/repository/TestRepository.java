package com.example.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.memo.entity.TestEntity;

public interface TestRepository extends JpaRepository<TestEntity, Integer> {

}
