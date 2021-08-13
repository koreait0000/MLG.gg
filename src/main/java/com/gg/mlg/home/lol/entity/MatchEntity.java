package com.gg.mlg.home.lol.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
