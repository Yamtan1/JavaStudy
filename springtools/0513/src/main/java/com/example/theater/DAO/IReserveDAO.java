package com.example.theater.DAO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IReserveDAO {

	int reserveCount(@Param ("id") String id);

	void insert(@Param("id") String id,@Param("title") String title, @Param("choicedate")String choicedate, @Param("seats") String seats);

}
