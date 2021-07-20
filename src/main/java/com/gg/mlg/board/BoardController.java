package com.gg.mlg.board;


import com.gg.mlg.board.model.BoardEntity;
import com.gg.mlg.board.model.SearchInfo;
import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
public class BoardController {

    @Autowired
    private BoardService service;

    /*처음 리스트페이지 출력용*/
    @GetMapping ("board/list")
    public String board(Model model, @Parameter SearchInfo param){
        /*초기화 작업*/
        param.setOrder("board_no");
        param.setPcnt(10);
        param.setPsnum(1);
        model.addAttribute("cpage",1);
        model.addAttribute("page",service.dividePage(param));
        model.addAttribute("list",service.selBoardList(param));
        return "board/list";
    }
    /*리스트페이지 ajax용*/
    @ResponseBody
    @PostMapping("board/list")
    public List<BoardEntity> boardAjax(@Parameter SearchInfo param){
        return service.selBoardList(param);
    }
    /*page처리 */
    @ResponseBody
    @PostMapping("board/page")
    public int boardPage(@Parameter SearchInfo param){
        return service.dividePage(param);
    };

    @GetMapping ("board/detail")
    public String detail(@Parameter BoardEntity param,Model model){
        model.addAttribute("data",service.selBoard(param));
        return "board/detail";
    }

    @GetMapping("board/write")
    public String write(){
        return "board/write";
    }
    @PostMapping("board/write")
    public  String  writeBoard(BoardEntity param){
        service.insBoard(param);
        return "board/list";
    }
}
