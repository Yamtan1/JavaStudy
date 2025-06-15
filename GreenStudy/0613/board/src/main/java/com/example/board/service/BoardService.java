package com.example.board.service;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public List<Board> getBoardList() {
        return boardRepository.findAllWithMember();
    }
    @Transactional
    public void insertBoard(Board board){
        boardRepository.save(board);
    }
}
