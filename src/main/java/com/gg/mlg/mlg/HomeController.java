package com.gg.mlg.mlg;

import com.gg.mlg.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public String tilesTest(Principal principal, Model model){
        model.addAttribute("data",0);
        if(principal!=null){
            model.addAttribute("data",service.selLoginUser(principal.getName()));
        }
        return "/home";
    }

    @GetMapping("/chat")
    public String chatTest() { return "temp/chat"; }
}
