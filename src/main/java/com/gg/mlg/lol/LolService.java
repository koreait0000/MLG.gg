package com.gg.mlg.lol;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gg.mlg.lol.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.Charset;
import java.util.ArrayList;

@Service
public class LolService {
    //api 키 값
    final String api_key = "RGAPI-d40d1205-9ad3-4eab-b088-6c4c201d043d";
    MatchDetailEntity[] MatchDetailList = null;
    ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Autowired
    private LolMapper mapper;

    public Object getId(String search_id) {
        ArrayList<GetChampionEntity> championList = new ArrayList<GetChampionEntity>();

        final String URL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + search_id;

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("api_key", api_key)
                .build(false);

        RestTemplate rest = new RestTemplate();
        rest.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        ResponseEntity<String> respEntity = rest.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);

        String result = respEntity.getBody();

        IdEntity idEn = null;
        try {
            JsonNode json = om.readTree(result);
            idEn = om.treeToValue(json, IdEntity.class);
            System.out.println(idEn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        final String URL2 = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/" + idEn.getAccountId();

        UriComponents builder2 = UriComponentsBuilder.fromHttpUrl(URL2)
                .queryParam("api_key", api_key)
                .queryParam("endIndex", 10)
                .queryParam("beginIndex", 0)
                .build(false);

        RestTemplate rest2 = new RestTemplate();
        rest2.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        ResponseEntity<String> respEntity2 = rest.exchange(builder2.toUriString(), HttpMethod.GET, null, String.class);

        String resultList = respEntity2.getBody();

        System.out.println("값 : " + resultList);

        MatchEntity[] list = null;
        try {
            JsonNode json = om.readTree(resultList);
            list = om.treeToValue(json.path("matches"), MatchEntity[].class);
            System.out.println("나나나나나 : " + list[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < list.length; i++) {
            championList.add(mapper.selChampion(list[i].getChampion()));
            championList.get(i).setGameId(list[i].getGameId());
        }


        System.out.println(championList.size());
        return championList;
    }

    public MatchDetailEntity[] getDetail(String gameId) {
        final String URL3 = "https://kr.api.riotgames.com/lol/match/v4/matches/" + gameId;
        UriComponents builder3 = UriComponentsBuilder.fromHttpUrl(URL3)
                .queryParam("api_key", api_key)
                .build(false);

        RestTemplate rest3 = new RestTemplate();
        rest3.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        ResponseEntity<String> respEntity3 = rest3.exchange(builder3.toUriString(), HttpMethod.GET, null, String.class);

        String resultMatchList = respEntity3.getBody();


        ObjectMapper om3 = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            JsonNode json = om.readTree(resultMatchList);
            MatchDetailList = om3.treeToValue(json.path("participants"), MatchDetailEntity[].class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(MatchDetailList);

//        ArrayList<Integer> dataNumList = new ArrayList<Integer>();
//        for(int i=0; i<MatchDetailList.length; i++) {
//            dataNumList.add(MatchDetailList[i].getChampionId());
//        }
//        System.out.println(dataNumList);
//        String[] spell1 = ;
//        String[] spell2 = ;

        ArrayList<ChampionAndSpell> CSList = new ArrayList<ChampionAndSpell>();
//        for(int i=0; i<MatchDetailList.length; i++) {
//            ChampionAndSpell param = new ChampionAndSpell();
//            param.setChampion_name(mapper.getChampions(MatchDetailList)[i]);
//            param.setSpell1_name(mapper.getSpell(MatchDetailList)[i]);
//            param.setSpell2_name(mapper.getSpell2(MatchDetailList)[i]);
//
//            CSList.add(param);
//        }

        System.out.println(mapper.getSpell2(MatchDetailList).length);
        System.out.println(mapper.getSpell2(MatchDetailList)[0]);
        System.out.println(mapper.getSpell2(MatchDetailList)[1]);
        System.out.println(mapper.getSpell1(MatchDetailList).length);
        System.out.println(mapper.getSpell1(MatchDetailList)[0]);
        System.out.println(mapper.getSpell1(MatchDetailList)[1]);
        System.out.println(mapper.getSpell1(MatchDetailList)[2]);
        System.out.println(mapper.getSpell1(MatchDetailList)[3]);
        for(int i=0; i<10; i++) {
            System.out.println(mapper.getChampions(MatchDetailList)[i]);
        }




        return MatchDetailList;
    }
}
