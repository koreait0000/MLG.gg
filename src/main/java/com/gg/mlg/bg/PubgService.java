package com.gg.mlg.bg;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gg.mlg.bg.model.PubgMatchInfo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.Charset;

@Service
public class PubgService {
    final String API = "";
    ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    RestTemplate rest = new RestTemplate();

    public void getUserId(String search_user) {
        final String URL = "https://api.pubg.com/shards/steam/players";

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("filter[playerNames]", search_user)
                .build(false);

        HttpHeaders headers = new HttpHeaders();
        headers.add("accept", "application/vnd.api+json");
        headers.add("Authorization", API);

        HttpEntity<String> entity = new HttpEntity<String>("header", headers);

        RestTemplate rest = new RestTemplate();
        rest.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        ResponseEntity<String> respEntity = rest.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);

        String result = respEntity.getBody();

        System.out.println(result);
        PubgMatchInfo[] test = null;

        try {
            JsonNode json = om.readTree(result);
            test = om.treeToValue(json.findPath("matches").path("data"), PubgMatchInfo[].class);
            System.out.println(test[3]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i = 0; i < test.length-40; i++) {
            final String URL2 = "https://api.pubg.com/shards/steam/matches/" + test[i].getId();
            UriComponents builder2 = UriComponentsBuilder.fromHttpUrl(URL2)
                    .build(false);



            rest.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

            respEntity = rest.exchange(builder2.toUriString(), HttpMethod.GET, entity, String.class);

            String result2 = respEntity.getBody();

            System.out.println(result2);

        }



        try {
            JsonNode json = om.readTree(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}