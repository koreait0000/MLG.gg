package com.gg.mlg.board;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping ("board/list")
    public String board(){
        return "board/list";
    }

    @GetMapping ("board/detail")
    public String detail(){
        return "board/detail";
    }



}
