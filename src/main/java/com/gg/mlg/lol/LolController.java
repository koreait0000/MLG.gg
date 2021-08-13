package com.gg.mlg.lol;

import com.gg.mlg.lol.ItemEntity.ItemFinalEntity;
import com.gg.mlg.lol.entity.GetChampionEntity;
import com.gg.mlg.lol.entity.MatchDetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lol")
public class LolController {

    @Autowired
    private LolService service;
    @Autowired
    private LolItemService itemService;

    @GetMapping("userSearch")
    public String lol(){
        return "lol/userSearch";
    }

    @GetMapping(value = "getID")
    public String getData(@RequestParam("search_id") String search_id, Model model) {
        model.addAttribute("data", service.getId(search_id));
        return "lol/userResult";
    }

    @ResponseBody
    @PostMapping(value = "/getDetail")
    public Map<String, MatchDetailEntity[]> getDetail(@RequestBody String gameId) {
        Map<String, MatchDetailEntity[]> res = new HashMap();
        res.put("details", service.getDetail(gameId));
        return res;
    }

    @GetMapping("itemSearch")
    public String moveItem(Model model) {
        model.addAttribute("data", itemService.getItem());
        return "lol/itemSearch";
    }

    @ResponseBody
    @PostMapping("itemSearch")
    public ArrayList<ItemFinalEntity> tagsItem(@RequestBody String num) {
        return itemService.makeTagItems(num);
    }

    @ResponseBody
    @PostMapping("firstItemMenu")
    public ArrayList<ItemFinalEntity> firstItem() {
        return itemService.getItem();
    }

}
