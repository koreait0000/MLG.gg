package com.gg.mlg.home.lol.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChampionsEntity {
    private int champion_no;
    private String champion_name;
    private String champion_KRname;

    private String[] sort_no = {"0", "5", "13", "16", "33", "41", "55", "74", "104",
            "118", "119", "138", "148", "153", "155"};

    private String[] sort_str = {"ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ",
            "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"};

}
