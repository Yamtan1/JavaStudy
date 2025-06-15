package com.example.demo2.repository;

import com.example.demo2.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("SELECT b FROM Board b JOIN FETCH b.member")
    public List<Board> getBoardListWithMember();


}
