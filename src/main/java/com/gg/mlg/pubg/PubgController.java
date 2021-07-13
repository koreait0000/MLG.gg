package com.gg.mlg.pubg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PubgController {

    @Autowired
    private PubgService service;

    @ResponseBody
    @PostMapping("/save")
    public int saveId(@RequestBody PubgEntity param) {
        System.out.println(param);
        return service.saveId(param);
    }
}
