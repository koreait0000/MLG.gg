package com.gg.mlg.mlg;

import com.gg.mlg.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class TestController {

    @GetMapping("/home")
    public String tilesTest(@AuthenticationPrincipal UserDetailsImpl userDetails,
                            Model model){
        model.addAttribute("data", userDetails.getUser().getUid());
        System.out.println(userDetails.getUser().getUid());
        return "temp/hello";
    }

    @GetMapping("/chat")
    public String chatTest() { return "temp/chat"; }
}
