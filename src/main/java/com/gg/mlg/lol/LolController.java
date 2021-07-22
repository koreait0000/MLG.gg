package com.gg.mlg.lol;

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
}
