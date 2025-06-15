package com.example.board.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ex_board")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Board extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno;
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Member member;

}
