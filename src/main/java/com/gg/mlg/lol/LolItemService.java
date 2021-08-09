package com.gg.mlg.lol;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gg.mlg.lol.ItemEntity.ItemEntity;
import com.gg.mlg.lol.ItemEntity.ItemFinalEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

@Service
public class LolItemService {
    ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    RestTemplate rest = new RestTemplate();


    public ArrayList<ItemFinalEntity> getItem() {
        ArrayList<ItemFinalEntity> itemList = new ArrayList<ItemFinalEntity>();

        final String URL = "http://ddragon.leagueoflegends.com/cdn/11.15.1/data/en_US/item.json";

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(URL)
                .build(false);

        rest.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        ResponseEntity<String> respEntity = rest.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);

        String result = respEntity.getBody();

        ItemEntity param = null;
        ItemFinalEntity goldParam = null;
        try {
            JsonNode json = om.readTree(result);
            param = om.treeToValue(json, ItemEntity.class);
            Iterator<String> keys = param.getData().keySet().iterator();
            while( keys.hasNext()) {
                String key = keys.next();
                ItemFinalEntity entity = new ItemFinalEntity();
                goldParam = om.treeToValue(json.findPath(key).path("gold"), ItemFinalEntity.class);
                entity.setItemNo(key);
                entity.setTotal(goldParam.getTotal());
                entity.setInto(param.getData().get(key).getInto());
                entity.setName(param.getData().get(key).getName());
                entity.setTags(param.getData().get(key).getTags());
                itemList.add(entity);
            }
            System.out.println(itemList.get(1));
            System.out.println(itemList.size());
            System.out.println(itemList.get(221));
            System.out.println(param.getData().get("1001"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemList;
    }
}
