package com.gg.mlg.pubg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PubgService {

    @Autowired
    private PubgMapper mapper;

    public int saveId(PubgEntity param) {
        return mapper.saveId(param);
    }
}
