package com.gg.mlg.lol;

import com.gg.mlg.lol.entity.GetChampionEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LolMapper {
    GetChampionEntity selChampion(int championId);
}
