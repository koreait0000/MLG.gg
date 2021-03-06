package com.gg.mlg.home.lol;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gg.mlg.board.model.BoardDomain;
import com.gg.mlg.board.model.BoardListDomain;
import com.gg.mlg.home.lol.entity.*;
import com.gg.mlg.user.model.ProfilepageEntity;
import com.gg.mlg.user.model.UserEntity;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Service
public class LolService {

    @Value("${spring.sendgrid.api-key}")
    private String api_key;

    MatchDetailEntity[] MatchDetailList = null;

    ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    RestTemplate rest = new RestTemplate();

    @Autowired
    private LolMapper mapper;

    public Object getId(String search_id) {
        ArrayList<GetChampionEntity> championList = new ArrayList<GetChampionEntity>();

        IdEntity idEn=callIdEntity(search_id);

        final String URL2 = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/" + idEn.getAccountId();

        UriComponents builder2 = UriComponentsBuilder.fromHttpUrl(URL2)
                .queryParam("api_key", api_key)
                .queryParam("endIndex", 20)
                .queryParam("beginIndex", 0)
                .build(false);

        rest.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        ResponseEntity<String> respEntity2 = rest.exchange(builder2.toUriString(), HttpMethod.GET, null, String.class);
        String resultList = respEntity2.getBody();

        MatchEntity[] list = null;
        try {
            JsonNode json = om.readTree(resultList);
            list = om.treeToValue(json.path("matches"), MatchEntity[].class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < list.length; i++) {
            championList.add(mapper.selChampion(list[i].getChampion()));
            System.out.println(championList.get(i));
            championList.get(i).setGameId(list[i].getGameId());
        }
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

        List<SpellEntity> AllSpell = mapper.getSpell();
        List<ChampionsEntity> AllChampions = mapper.getChampion();

        for (int i = 0; i < MatchDetailList.length; i++) {
            int spell1 = MatchDetailList[i].getSpell1Id();
            int spell2 = MatchDetailList[i].getSpell2Id();
            int champion = MatchDetailList[i].getChampionId();
            for (int j = 0; j < AllSpell.size(); j++) {
                if (spell1 == AllSpell.get(j).getSpell_no()) {
                    MatchDetailList[i].setSpell1_name(AllSpell.get(j).getSpell_name());
                }
                if (spell2 == AllSpell.get(j).getSpell_no()) {
                    MatchDetailList[i].setSpell2_name(AllSpell.get(j).getSpell_name());
                }
            }
            for(int z = 0; z < AllChampions.size(); z++) {
                if(champion == AllChampions.get(z).getChampion_no()) {
                    MatchDetailList[i].setChampion_name(AllChampions.get(z).getChampion_name());
                }
            }
        }
        return MatchDetailList;
    }

    public ProfilepageEntity makeProfile(UserEntity param) {
        ProfilepageEntity lprofile=new ProfilepageEntity();
        IdEntity idEn=callIdEntity(param.getLname());
        lprofile.setProfileIconId(idEn.getProfileIconId());
        lprofile.setSummonerLevel(idEn.getSummonerLevel());
        String url="https://kr.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/";
        ChampionMastery[] arr = callObjectarr(url,idEn.getId());
        for (int i = 0; i < arr.length; i++) {
           GetChampionEntity gce=mapper.selChampion(arr[i].getChampion_no());
            arr[i].setChampion_name(gce.getChampion_name());
            arr[i].setChampion_KRname(gce.getChampion_KRname());
        }
        lprofile.setMastery(arr);
        lprofile.setRank(callLeagueEntity(idEn.getId()));
        System.out.println(idEn.getName());
        return lprofile;
    }

    public IdEntity callIdEntity(String searchnick){
        final String URL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + searchnick;
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("api_key", api_key)
                .build(false);
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
        return idEn;
    }
    public ChampionMastery[] callObjectarr(String url, String search){
        final String URL =url+search;
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("api_key", api_key)
                .build(false);
        rest.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        ResponseEntity<String> respEntity = rest.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);
        String resultList = respEntity.getBody();
        ChampionMastery[] list = null;
        try {
            JsonNode json = om.readTree(resultList);
            list = om.treeToValue(json, ChampionMastery[].class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public RankEntity[] callLeagueEntity(String searchnick){
        final String URL = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + searchnick;
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("api_key", api_key)
                .build(false);
        rest.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        ResponseEntity<String> respEntity = rest.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);
        String result = respEntity.getBody();
        RankEntity[] rkeN=null;
        try {
            JsonNode json = om.readTree(result);
            rkeN = om.treeToValue(json, RankEntity[].class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rkeN;
    }

    public ChampionsEntity[] getChampionSort() {
        ChampionsEntity[] championsList = mapper.getChampionSort();
        return championsList;
    }

    public List<GetChampionEntity> rotation() {
        List<GetChampionEntity> rotation =new ArrayList<>();
        final String URL = "https://kr.api.riotgames.com/lol/platform/v3/champion-rotations";
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("api_key", api_key)
                .build(false);
        rest.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        ResponseEntity<String> respEntity = rest.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);
        String result = respEntity.getBody();
        freeChampionEntity fce=null;
        try {
            JsonNode json = om.readTree(result);
            fce=om.treeToValue(json,freeChampionEntity.class);
            for (int i=0;i<fce.getFree().length;i++){
                rotation.add(mapper.selChampion(fce.getFree()[i]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rotation;
    }

    public BoardDomain makebp(BoardDomain selBoard) {
        selBoard.setProfileIconId(callIdEntity(selBoard.getLname()).getProfileIconId());
        return selBoard;
    }
}
