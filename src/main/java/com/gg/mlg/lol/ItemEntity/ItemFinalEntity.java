package com.gg.mlg.lol.ItemEntity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class ItemFinalEntity {

    private String itemNo;
    private String name;
    private String[] into;

    @JsonProperty("total")
    private String total;

    private String[] tags;

    private String plaintext;

    private Map<String, String> stats;
}
