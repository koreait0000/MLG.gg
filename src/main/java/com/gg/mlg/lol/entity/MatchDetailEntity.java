package com.gg.mlg.lol.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MatchDetailEntity {

    @JsonProperty("participantId")
    private int participantId;

    @JsonProperty("championId")
    private int championId;

    @JsonProperty("spell1Id")
    private int spell1Id;

    @JsonProperty("spell2Id")
    private int spell2Id;

    private String champion_name;

    private String spell1_name;

    private String spell2_name;

    @JsonProperty("stats")
    private Stats stats;

}
