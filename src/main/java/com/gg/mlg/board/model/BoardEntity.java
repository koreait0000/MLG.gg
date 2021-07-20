package com.gg.mlg.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardEntity {
    private int board_no;
    private String title;
    private String ctnt;
    private String regdt;
    private int user_no;
    private int views;
}
