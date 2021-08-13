package com.gg.mlg.home.lol.ItemEntity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class ItemDetailEntity {
    @JsonProperty("name")
    private String name;

    @JsonProperty("into")
    private String[] into;

    @JsonProperty("gold")
    private Map<String, String> gold;

    @JsonProperty("tags")
    private String[] tags;

    @JsonProperty("plaintext")
    private String plaintext;

    @JsonProperty("stats")
    private Map<String, String> stats;

    private String item;
}
