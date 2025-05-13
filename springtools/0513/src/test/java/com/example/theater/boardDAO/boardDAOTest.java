package com.example.theater.boardDAO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.theater.DAO.IBoardDAO;
import com.example.theater.DTO.BoardDTO;

@SpringBootTest
class boardDAOTest {

	@Autowired
	IBoardDAO boarddao;
	@Test
	void testInsert() {
		for(int i = 0; i < 100; i++) {
			BoardDTO board = new BoardDTO();
			board.setTitle("title...." + i);
			board.setContent("Content..." + i);
			board.setWrite("gngn1234");
			
			boarddao.insertNotice(board.getTitle(), board.getContent(), board.getWrite());
		}
	}

}
