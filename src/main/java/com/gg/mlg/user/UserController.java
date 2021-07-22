package com.gg.mlg.user;


import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String login(){
        return "user/login";
    }


    @GetMapping ("join")
    public String join() { return "user/join";}

    @PostMapping("join")
    public String inJoin(HttpServletRequest req, @Parameter UserEntity param) {
        service.inJoin(param);
        return "user/login";}

    @GetMapping("/profile")
    public String profile(@Parameter UserEntity param, Model model){
        model.addAttribute("data",service.selUser(param));
        return "user/profile";
    }

}
