package com.gg.mlg.home;

import com.gg.mlg.home.lol.LolService;
import com.gg.mlg.user.UserService;
import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class HomeController {

    @Autowired
    private UserService service;

    @Autowired
    private LolService lolservice;


    @GetMapping("home")
    public void home(){}


    @GetMapping("chat")
    public String chat(@Parameter String lname, Model model){
        model.addAttribute("lname", lname);
        return "chat";
    }


    @GetMapping("home/lol")
    public void lolhome(Model model) throws IOException {
        model.addAttribute("Rotation",lolservice.rotation());
    }


}
