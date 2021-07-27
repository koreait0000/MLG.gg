package com.gg.mlg.lol;

import com.gg.mlg.lol.entity.GetChampionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LolController {

    @Autowired
    private LolService service;

    @GetMapping(value="/getID")
    public String getData(@RequestParam("search_id")String search_id, Model model) {
        model.addAttribute("data", service.getId(search_id));
        return "result/lol";
    }

    @ResponseBody
    @PostMapping("getDetail")
    public String getDetail(@RequestBody String gameId, Model model) {
        System.out.println("스윗트걸");
//        model.addAttribute("detail", service.getDetail(gameId));
        return "result/lol";
    }
}
