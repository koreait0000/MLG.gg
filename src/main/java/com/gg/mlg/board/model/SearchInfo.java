package com.gg.mlg.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchInfo {
    private String order;
    private int psnum;
    private int pdivide;
    public void setPsnum(int psnum) {
        this.psnum = (psnum - 1) * 15;
    }
}
