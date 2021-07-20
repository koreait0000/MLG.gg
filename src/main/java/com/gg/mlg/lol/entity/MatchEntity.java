package com.gg.mlg.lol.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MatchEntity {
    @JsonProperty("gameId")
    private String gameId;

    @JsonProperty("champion")
    private int champion;

    @JsonProperty("queue")
    private int queue;

    @JsonProperty("timestamp")
    private String timestamp;

}
