package com.gg.mlg.user;

import com.gg.mlg.lol.LolService;
import com.gg.mlg.user.model.UserEntity;
import com.gg.mlg.user.model.UserProfileEntity;
import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private LolService lolservice;


    @GetMapping("login")
    public String login(HttpServletRequest request) {
        String refer=request.getHeader("Referer");
//        if(refer.contains("/user/login")){
//            refer="http://localhost:8090/home";
//        }
        try{
            refer.contains("/user/login");
        }catch(NullPointerException e){
            refer="http://localhost:8090/home";
        }
        request.getSession().setAttribute("prevPage",refer);
        return "user/login";
    }

    @GetMapping("join")
    public String join() {
        return "user/join";
    }

    @PostMapping("/user/join")
    public String inJoin(@Parameter UserEntity param) {
        service.inJoin(param);
        return "user/login";
    }

    @ResponseBody
    @PostMapping("follow")
    public int follow(@RequestBody UserEntity param){
        System.out.println(param);
        return service.indelfollow(param);
    }

    @GetMapping("profile")
    public String profile(@Parameter UserEntity param, Model model) {
        UserEntity result=service.selUser(param);
        model.addAttribute("pud", result);
        if(result.getLname()!=null){
        model.addAttribute("pudlol",lolservice.makeProfile(result));
        }
        model.addAttribute("writelist", service.selWriteCnt(result.getUser_no()));
        System.out.println(result);
        model.addAttribute("woolist", service.selfollow(param));
        model.addAttribute("winglist", service.selfollowing(param));
        return "user/profile";
    }
//    @PostMapping("/profileImg")
//    public String profileImg(MultipartFile[] imgArr) {
//        service.profileImg(imgArr);
//        return "redirect:profile";
//    }
//    @ResponseBody
//    @GetMapping("/mainProfile")
//    public Map<String, Object> mainProfile(UserProfileEntity param) {
//        return service.updUserMainProfile(param);
//    }
}
