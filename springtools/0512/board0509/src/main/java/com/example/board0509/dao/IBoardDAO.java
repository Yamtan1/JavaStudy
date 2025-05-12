package com.example.board0509.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.board0509.dto.BoardDTO;

@Mapper
public interface IBoardDAO {

	List<BoardDTO> getList();
	
	void boardInsert(BoardDTO board);

	List<BoardDTO> getPageList(@Param("startRow") int startRow, @Param("endRow") int endRow);
	
	int getTotalCount();
}
