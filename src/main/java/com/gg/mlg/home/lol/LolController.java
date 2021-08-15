package com.gg.mlg.home.lol;

import com.gg.mlg.home.lol.ItemEntity.ItemFinalEntity;
import com.gg.mlg.home.lol.ItemEntity.Tagimgurl;
import com.gg.mlg.home.lol.entity.MatchDetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/home/lol")
public class LolController {

    private String location="home/lol/";

    @Autowired
    private LolService service;

    @Autowired
    private LolItemService itemService;

    @GetMapping("user_s")
    public void lol(){}

    @GetMapping("user_r")
    public void getData(@RequestParam("search_id") String search_id, Model model) {
        model.addAttribute("data", service.getId(search_id));
    }

    @ResponseBody
    @PostMapping(value = "/getDetail")
    public Map<String, MatchDetailEntity[]> getDetail(@RequestBody String gameId) {
        Map<String, MatchDetailEntity[]> res = new HashMap();
        res.put("details", service.getDetail(gameId));
        return res;
    }

    @GetMapping("item")
    public void moveItem(Model model) {
        model.addAttribute("data", itemService.getItem());
        model.addAttribute("tagurl", new Tagimgurl());
    }

    @ResponseBody
    @PostMapping("item")
    public ArrayList<ItemFinalEntity> tagsItem(@RequestBody String num) {
        return itemService.makeTagItems(num);
    }

    @ResponseBody
    @PostMapping("firstItemMenu")
    public ArrayList<ItemFinalEntity> firstItem() {
        return itemService.getItem();
    }

}
