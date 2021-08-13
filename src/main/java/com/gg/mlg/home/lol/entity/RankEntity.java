package com.gg.mlg.home.lol.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RankEntity {
    @JsonProperty("tier")
    private String tier;
    @JsonProperty("rank")
    private String rank;
    @JsonProperty("leaguePoints")
    private String leaguePoints;
    @JsonProperty("wins")
    private String wins;
    @JsonProperty("losses")
    private String losses;
}
