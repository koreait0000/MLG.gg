package com.gg.mlg.bg;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PubgController {

    @GetMapping(value="/search_player")
    public String getPlayer(@RequestParam("search_id")String search_id) {
        System.out.println(search_id);
        return "result/bg";
    }

}
