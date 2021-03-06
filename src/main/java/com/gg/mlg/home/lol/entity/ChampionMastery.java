package com.gg.mlg.home.lol.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChampionMastery {

    @JsonProperty("championId")
    private int champion_no;

    private String champion_name;

    private String champion_KRname;

    @JsonProperty("championLevel")
    private int championLevel;

    @JsonProperty("championPoints")
    private int championPoints;

}
