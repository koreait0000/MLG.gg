package com.gg.mlg.lol.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Stats {
    @JsonProperty("win")
    private String win;

    @JsonProperty("item0")
    private String item0 ;

    @JsonProperty("item1")
    private String item1 ;

    @JsonProperty("item2")
    private String item2 ;

    @JsonProperty("item3")
    private String item3;

    @JsonProperty("item4")
    private String item4 ;

    @JsonProperty("item5")
    private String item5 ;

    @JsonProperty("item6")
    private String item6 ;

    @JsonProperty("kills")
    private String kills ;

    @JsonProperty("deaths")
    private String deaths ;

    @JsonProperty("assists")
    private String assists ;

    @JsonProperty("totalDamageDealtToChampions")
    private String totalDamageDealtToChampions;

    @JsonProperty("totalMinionsKilled")
    private String totalMinionsKilled;

}
