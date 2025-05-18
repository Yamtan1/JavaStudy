package com.example.exam0516.DAO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ExamDAO {

	void insert(@Param("id")String id, @Param("phone")String phone);
	

}
