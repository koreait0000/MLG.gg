package com.gg.mlg.lol.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetChampionEntity {
    private int champion_no;
    private String champion_name;
    private String champion_KRname;
    private String gameId;
}
