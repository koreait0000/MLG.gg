package com.gg.mlg.lol;

import com.gg.mlg.lol.entity.ChampionAndSpell;
import com.gg.mlg.lol.entity.GetChampionEntity;
import com.gg.mlg.lol.entity.MatchDetailEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface LolMapper {
    GetChampionEntity selChampion(int championId);
    String[] getChampions(MatchDetailEntity[] param);
    String[] getSpell1(MatchDetailEntity[] param);
    String[] getSpell2(MatchDetailEntity[] param);
}
