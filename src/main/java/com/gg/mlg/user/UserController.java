package com.gg.mlg.user;


import com.gg.mlg.user.model.UserEntity;
import com.gg.mlg.user.model.UserProfileEntity;
import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }


    @GetMapping("join")
    public String join() {
        return "user/join";
    }

    @PostMapping("join")
    public String inJoin(@Parameter UserEntity param) {
        service.inJoin(param);
        return "user/login";
    }

    @GetMapping("/profile")
    public String profile(@Parameter UserEntity param, Model model) {
        System.out.println(param);
        model.addAttribute("pud", service.selUser(param));
        model.addAttribute("woolist", service.selfollow(param));
        model.addAttribute("winglist", service.selfollowing(param));
        return "user/profile";
    }
    @ResponseBody
    @PostMapping("/follow")
    public int follow(@RequestBody UserEntity param){
        System.out.println(param);
        return service.indelfollow(param);
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
