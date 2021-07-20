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

//    @JsonProperty("stats")
//    private String stats;

}
