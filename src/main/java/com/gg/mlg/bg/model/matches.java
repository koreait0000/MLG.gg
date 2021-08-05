package com.gg.mlg.bg.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class matches {

    @JsonProperty("matches")
    private Map<String, PubgMatchInfo[]> matches;

}
