package com.example.board.repository;

import com.example.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    @Query("SELECT b FROM Board b JOIN FETCH b.member")
    List<Board> findAllWithMember();
}
