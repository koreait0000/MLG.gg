package com.gg.mlg.user.model;

import com.gg.mlg.lol.entity.ChampionMastery;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProfilepageEntity {
    private int profileIconId;
    private int summonerLevel;
    private ChampionMastery[] mastery;
}
