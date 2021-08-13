package com.gg.mlg.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchInfo {
    private String order;
    private String searchval;
    private int pnum;
    private int psnum;
    public void setPnum(int pnum) {
        this.pnum=pnum;
        this.psnum = (pnum - 1) * 15;
    }
}
