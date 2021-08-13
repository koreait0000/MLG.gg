package com.gg.mlg.home.lol.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class IdEntity {

    @JsonProperty("id")
    private String id;

    @JsonProperty("accountId")
    private String accountId;

    @JsonProperty("puuid")
    private String puuid;

    @JsonProperty("name")
    private String name;

    @JsonProperty("profileIconId")
    private int profileIconId;

    @JsonProperty("summonerLevel")
    private int summonerLevel;
}
