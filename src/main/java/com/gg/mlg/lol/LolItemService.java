package com.gg.mlg.lol;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gg.mlg.lol.ItemEntity.ItemDeleteEntity;
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
import java.util.Arrays;
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
                entity.setStats(param.getData().get(key).getStats());
                entity.setPlaintext(param.getData().get(key).getPlaintext());
                entity.setInto(param.getData().get(key).getInto());
                entity.setName(param.getData().get(key).getName());
                entity.setTags(param.getData().get(key).getTags());
                itemList.add(entity);
                ItemDeleteEntity delete_noArr = new ItemDeleteEntity();
                for(int i=0;i<delete_noArr.getDelete_no().length;i++){
                    if(entity.getItemNo().equals(delete_noArr.getDelete_no()[i])||entity.getTotal().equals("0")){
                        itemList.removeAll(Arrays.asList(entity));
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemList;
    }
}
