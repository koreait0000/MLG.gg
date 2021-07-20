package com.gg.mlg.board.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchInfo {
    private String order;
    private int pcnt;
    private int psnum;
    private int pdivide;
    /*주의*/
    public void setPsnum(int psnum) {
        this.psnum = (psnum - 1) * pcnt;
    }
}
