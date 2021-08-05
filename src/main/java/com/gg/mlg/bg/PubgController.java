package com.gg.mlg.bg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PubgController {

    @Autowired
    private PubgService service;

    @GetMapping(value="/getUser")
    public String getUser(@RequestParam("search_user")String search_user) {
        System.out.println(search_user);
        service.getUserId(search_user);
        return "result/bg";
    }
}
