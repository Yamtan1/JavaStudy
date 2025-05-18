package com.example.exam0516.DAO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ExamResultDAO {

	void insert(@Param("id")String id, @Param("phone")String phone, @Param("q1")String q1, 
				@Param("q2")String q2, @Param("q3")String q3, @Param("q4")String q4, @Param("q5")String q5);
}
