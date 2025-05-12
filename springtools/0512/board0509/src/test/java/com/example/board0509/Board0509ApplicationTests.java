package com.example.board0509;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.board0509.dao.IBoardDAO;
import com.example.board0509.dto.BoardDTO;

@SpringBootTest
class Board0509ApplicationTests {
	@Autowired
	IBoardDAO boarddao;
	@Test
	void testInsert() {
		for(int i = 0; i < 100; i++) {
			BoardDTO board = new BoardDTO();
			board.setTitle("title...." + i);
			board.setContent("Content..." + i);
			board.setWrite("aaa123");
			board.setRegdate("SYSDATE");
			boarddao.boardInsert(board);
			
		}
	}

}
