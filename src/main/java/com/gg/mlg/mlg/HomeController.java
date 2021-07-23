package com.gg.mlg.mlg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private HomeService service;
    @GetMapping("/home")
    public String home(Principal principal, Model model){
        model.addAttribute("data",0);
        if(principal!=null){
            model.addAttribute("data",service.selLoginUser(principal.getName()));
        }
        return "temp/home";
    }
    @GetMapping("/lol")
    public String lol(Principal principal, Model model){
        return "lol";
    }
    @GetMapping("/bg")
    public String bg(Principal principal, Model model){
        return "bg";
    }



    @GetMapping("/chat")
    public String chatTest() { return "temp/chat"; }
}
