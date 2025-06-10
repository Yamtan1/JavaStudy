package com.example.memo.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.memo.entity.TestEntity;

@SpringBootTest
class TestRepositoryTest {
	
	@Autowired
	TestRepository testRepository;
	
	@Test
	void insertTest() {
		TestEntity test1 = new TestEntity();
		test1.setTxt("test1..........");
		TestEntity result = null;
		assertNotNull(result, "null이아니어야하는데....");
	}
	/* void insertTest() {
		TestEntity test = new TestEntity();
		test.setTxt("test1..........");
		TestEntity result = testRepository.save(test);
		assertNotNull(result);
	} */

}
