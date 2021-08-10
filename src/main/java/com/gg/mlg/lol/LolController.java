package com.gg.mlg.lol;

import com.gg.mlg.lol.ItemEntity.ItemFinalEntity;
import com.gg.mlg.lol.entity.GetChampionEntity;
import com.gg.mlg.lol.entity.MatchDetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LolController {

    @Autowired
    private LolService service;
    @Autowired
    private LolItemService itemService;

    @GetMapping(value = "/getID")
    public String getData(@RequestParam("search_id") String search_id, Model model) {
        model.addAttribute("data", service.getId(search_id));
        return "result/lol";
    }


    @ResponseBody
    @PostMapping(value = "/getDetail")
    public Map<String, MatchDetailEntity[]> getDetail(@RequestBody String gameId) {
        Map<String, MatchDetailEntity[]> res = new HashMap();
        res.put("details", service.getDetail(gameId));
        return res;
    }

    @GetMapping("/lolItem")
    public String moveItem(Model model) {
        model.addAttribute("data", itemService.getItem());
        return "lolItem";
    }

    @ResponseBody
    @PostMapping("/lolItem")
    public ArrayList<ItemFinalEntity> tagsItem(@RequestBody String num) {
        int switch_no = Integer.parseInt(num)-1;
        ArrayList<ItemFinalEntity> List = itemService.getItem();
        Map<Integer, String[]> tags = new HashMap<>();
        String[][] tags_string = new String[][]{{"Damage"},
                {"CriticalStrike"},
                {"AttackSpeed"},
                {"OnHit"},
                {"ArmorPenetration"},
                {"SpellDamage"},
                {"ManaRegen", "Mana"},
                {"MagicPenetration"},
                {"Health", "HealthRegen"},
                {"Armor"},
                {"SpellBlock"},
                {"CooldownReduction", "AbilityHaste"},
                {"boots", "NonbootsMovement", "Slow", "Tenacity"},
                {"LifeSteal", "SpellVamp"},
                {"Consumable"}};
        for (int i = 0; i < 15; i++) {
            tags.put(i, tags_string[i]);
        }
        ArrayList<ItemFinalEntity> tagsItem = new ArrayList<ItemFinalEntity>();
        for(int i=0; i<List.size(); i++) {
            int isIn = 0;
            for(int j=0; j<List.get(i).getTags().length; j++) {
                for(int k=0; k<tags.get(switch_no).length; k++) {
                    if (List.get(i).getTags()[j].equals(tags.get(switch_no)[k])) {
                        tagsItem.add(List.get(i));
                        isIn++;
                        break;
                    }
                }
                if(isIn == 0) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return tagsItem;
    }

}
