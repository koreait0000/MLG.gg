package com.gg.mlg.home.lol.ItemEntity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Map;

@Getter
@Setter
@ToString
public class ItemEntity {
    @JsonProperty("data")
    private Map<String, ItemDetailEntity> data;

    private ArrayList<String> itemNo;

}
