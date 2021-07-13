package com.gg.mlg.pubg;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PubgMapper {
    int saveId(PubgEntity param);
}
