package com.gg.mlg.lol;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gg.mlg.lol.entity.IdEntity;
import com.gg.mlg.lol.entity.MatchDetailEntity;
import com.gg.mlg.lol.entity.MatchEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.Charset;

@Service
public class LolService {
    final String api_key = "RGAPI-e41e5514-435a-4976-9caa-649d2ba9aae8";
    MatchDetailEntity[] MatchDetailList = null;

    @Autowired
    private LolMapper mapper;

    public Object getId(String search_id) {
        final String URL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + search_id;

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("api_key", api_key)
                .build(false);

        RestTemplate rest = new RestTemplate();
        rest.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        ResponseEntity<String> respEntity = rest.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);

        String result = respEntity.getBody();

        ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
                .queryParam("endIndex", 40)
                .queryParam("beginIndex", 0)
                .build(false);

        RestTemplate rest2 = new RestTemplate();
        rest2.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        ResponseEntity<String> respEntity2 = rest.exchange(builder2.toUriString(), HttpMethod.GET, null, String.class);

        String resultList = respEntity2.getBody();

        System.out.println("값 : " + resultList);
        ObjectMapper om2 = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MatchEntity[] list = null;
        try {
            JsonNode json = om.readTree(resultList);
            list = om2.treeToValue(json.path("matches"), MatchEntity[].class);
            System.out.println("나나나나나 : " + list[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i=0; i<list.length; i++) {
            final String URL3 = "https://kr.api.riotgames.com/lol/match/v4/matches/" + list[i].getGameId();
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
        }


        return MatchDetailList;
    }
}
