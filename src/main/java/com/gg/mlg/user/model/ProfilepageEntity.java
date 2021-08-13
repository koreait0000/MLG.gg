package com.gg.mlg.user.model;

import com.gg.mlg.home.lol.entity.ChampionMastery;
import com.gg.mlg.home.lol.entity.RankEntity;
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
    private RankEntity[] rank;
}
