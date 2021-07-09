package com.gg.mlg.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

//    @PostMapping ("/login")
//    public String loginForm(HttpServletRequest req){
//        UserEntity param = new UserEntity();
//        param.setUid(req.getParameter("uid"));
//        param.setUpw(req.getParameter("upw"));
//        service.userLogin(param);
//        return "redirect:/home";
//    }

    @GetMapping ("join")
    public String join() { return "user/join";}

    @PostMapping("join")
    public String inJoin(HttpServletRequest req) {
        UserEntity param = new UserEntity();
        param.setLname(req.getParameter("Lname"));
        param.setPname(req.getParameter("Pname"));
        param.setUid(req.getParameter("uid"));
        param.setUpw(req.getParameter("upw"));
        service.inJoin(param);
        return "user/login";}
}
