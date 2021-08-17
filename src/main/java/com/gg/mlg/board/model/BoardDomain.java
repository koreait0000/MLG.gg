package com.gg.mlg.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDomain extends  BoardEntity{
    private  int prv;
    private  int nxt;
    private BoardimgEntity[] imgArr;
    private String lname;
    private String uid;
    private int profileIconId;
}
