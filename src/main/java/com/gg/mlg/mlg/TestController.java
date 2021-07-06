package com.gg.mlg.mlg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TestController {
    @GetMapping("/")
    public String index(){
        return "hello";
    }

}
