package com.gg.mlg.home.lol;

import com.gg.mlg.home.lol.entity.ChampionsEntity;
import com.gg.mlg.home.lol.entity.GetChampionEntity;
import com.gg.mlg.home.lol.entity.SpellEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface LolMapper {
    GetChampionEntity selChampion(int championId);
    List<ChampionsEntity> getChampion();
    ChampionsEntity[] getChampionSort();
    List<SpellEntity> getSpell();
}
