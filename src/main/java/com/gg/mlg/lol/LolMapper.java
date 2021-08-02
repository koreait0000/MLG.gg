package com.gg.mlg.lol;

import com.gg.mlg.lol.entity.ChampionsEntity;
import com.gg.mlg.lol.entity.GetChampionEntity;
import com.gg.mlg.lol.entity.MatchDetailEntity;
import com.gg.mlg.lol.entity.SpellEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LolMapper {
    GetChampionEntity selChampion(int championId);
    List<ChampionsEntity> getChampion();
    List<SpellEntity> getSpell();
}
