package com.example.theater.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.theater.DTO.BoardDTO;


@Mapper
public interface IBoardDAO {

	void insertNotice(@Param("title") String title, @Param("content") String content, @Param("write") String write);

	List<BoardDTO> getNoticeList(@Param("startRow") int startRow, @Param("endRow") int endRow);

	int getListCount();
	
	

}
