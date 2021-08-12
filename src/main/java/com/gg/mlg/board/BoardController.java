package com.gg.mlg.board;

import com.gg.mlg.board.model.BoardEntity;
import com.gg.mlg.board.model.SearchInfo;
import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping("/list")
    public String board(Model model, @Parameter SearchInfo param) {
        param.setOrder("board_no");
        param.setPcnt(10);
        param.setPsnum(1);
        model.addAttribute("cpage", 1);
        model.addAttribute("page", service.dividePage(param));
        model.addAttribute("list", service.selBoardList(param));
        return "board/list";
    }

    @ResponseBody
    @PostMapping("/list")
    public List<BoardEntity> boardAjax(@Parameter SearchInfo param) {
        return service.selBoardList(param);
    }

    @ResponseBody
    @PostMapping("/page")
    public int boardPage(@Parameter SearchInfo param) {
        return service.dividePage(param);
    }

    @GetMapping("/detail")
    public String detail(@Parameter BoardEntity param, Model model) {
        model.addAttribute("data", service.selBoard(param));
        return "board/detail";
    }

    @GetMapping("/write")
    public String write(Model model) {
        model.addAttribute("mode", "write");
        return "board/write";
    }

    @GetMapping("/update")
    public String update(@Parameter BoardEntity param, Model model) {
        model.addAttribute("mode", "update");
        model.addAttribute("board_data", service.selBoard(param));
        return "board/write";
    }

    @PostMapping("/write")
    public void writeBoard(BoardEntity param,HttpServletResponse response) throws Exception {
       alertpage(response,service.insBoard(param),"insert");
    }

    @PostMapping("/update")
    public void updateBoard(@Parameter BoardEntity param, HttpServletResponse response) throws Exception {
        alertpage(response, service.upBoard(param), "update");
    }

    @GetMapping("/delete")
    public void delete(@Parameter BoardEntity param, HttpServletResponse response) throws Exception {
        alertpage(response, service.delBoard(param), "delete");
    }

    private void alertpage(HttpServletResponse res, int result, String dowhat) throws Exception {
        res.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = res.getWriter();
        if (result > 0) {
            writer.println("<script>alert('Success " + dowhat + "'); location.href='/board/list';</script>");
        } else {
            writer.println("<script>alert('Fail " + dowhat + "'); location.href='/board/list';</script>");
        }
    }
}
