package com.gg.mlg.user;

import com.gg.mlg.home.lol.LolService;
import com.gg.mlg.user.model.UserEntity;
import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private LolService lolservice;

    @GetMapping("login")
    public String login(HttpServletRequest request) {
        String refer = request.getHeader("Referer");
        System.out.println(refer);
        try {
            if (refer.contains("/user/login")) {
                refer = "http://localhost:8090/home";
            }
        } catch (NullPointerException e) {
//            refer = "http://localhost:8090/home";
            return "redirect:/home";
        }
        request.getSession().setAttribute("prevPage", refer);
        return "user/login";
    }

    @GetMapping("join")
    public void join() {
    }

    @PostMapping("join")
    public String inJoin(@Parameter UserEntity param) {
        service.inJoin(param);
        return "user/login";
    }

    @ResponseBody
    @PostMapping("follow")
    public int follow(@RequestBody UserEntity param) {
        System.out.println(param);
        return service.indelfollow(param);
    }

    @GetMapping("profile")
    public void profile(@Parameter UserEntity param, Model model) {
        UserEntity result = service.selUser(param);
        model.addAttribute("pud", result);
        System.out.println(param);
        if (result.getLname() != null) {
            model.addAttribute("pudlol", lolservice.makeProfile(result));
        }
        model.addAttribute("writelist", service.selWriteCnt(result.getUser_no()));
        System.out.println(result);
        model.addAttribute("woolist", service.selfollow(param));
        model.addAttribute("winglist", service.selfollowing(param));
    }
}
