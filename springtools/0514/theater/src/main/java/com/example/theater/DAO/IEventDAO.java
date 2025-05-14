package com.example.theater.DAO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IEventDAO {

	int idCount(@Param("id") String id);

	void insert(@Param("id") String id);

}
