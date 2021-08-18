package com.gg.mlg.board;

import com.gg.mlg.board.model.BoardEntity;
import com.gg.mlg.board.model.BoardListDomain;
import com.gg.mlg.board.model.SearchInfo;
import com.gg.mlg.home.lol.LolService;
import com.gg.mlg.user.UserService;
import com.gg.mlg.user.model.UserEntity;
import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService service;

    @Autowired
    private UserService service2;

    @Autowired
    private LolService lolservice;


    @GetMapping("/list")
    public void board(Model model, @Parameter SearchInfo param) {
        param.setSearchval("");//초기검색값
        param.setOrder("board_no");//초기정렬순
        param.setPnum(1);//받아오는값 시작번호받기위한 초기값=현재페이지값으로 넣어주기
        model.addAttribute("cpage", param.getPnum());//현재페이지
        model.addAttribute("order",param.getOrder());//현재페이지
        model.addAttribute("page", service.dividePage(param));//총페이지수
        model.addAttribute("list", service.selBoardList(param));
    }

    @ResponseBody
    @PostMapping("/list")
    public List<BoardListDomain> boardAjax(@Parameter SearchInfo param, Model model, UserEntity param2) {
        UserEntity result = service2.selUser(param2);
        System.out.println(param);
        model.addAttribute("cpage", param.getPnum());//현재페이지
        model.addAttribute("page", service.dividePage(param));//총페이지수
        model.addAttribute("list",  service.selBoardList(param));
        return service.selBoardList(param);
    }

    @ResponseBody
    @PostMapping("/page")
    public int boardPage(@Parameter SearchInfo param) {
        return service.dividePage(param);
    }

    @GetMapping("/detail")
    public void detail(@Parameter BoardEntity param, Model model) {
        model.addAttribute("data", lolservice.makebp(service.selBoard(param)));
    }

    @GetMapping("/write")
    public void write(Model model) {
        model.addAttribute("mode", "write");
    }

    @GetMapping("/update")
    public String update(@Parameter BoardEntity param, Model model) {
        model.addAttribute("mode", "update");
        model.addAttribute("board_data", service.selBoard(param));
        return "board/write";
    }

    @PostMapping("/write")
    public void writeBoard(BoardEntity param, MultipartFile[] boardimg, HttpServletResponse response) throws Exception {
        System.out.println(boardimg);
        alertpage(response,service.insUpBoard(param,boardimg,0),"insert");
    }

    @PostMapping("/update")
    public void updateBoard(@Parameter BoardEntity param, MultipartFile[] boardimg, HttpServletResponse response) throws Exception {
        alertpage(response, service.insUpBoard(param,boardimg,1), "update");
    }

    @GetMapping("/delete")
    public void delete(@Parameter BoardEntity param, HttpServletResponse response) throws Exception {
        alertpage(response, service.delBoard(param), "delete");
    }

    private void alertpage(HttpServletResponse res, int result, String dowhat) throws Exception {
        res.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = res.getWriter();
        if (result !=0) {
            writer.println("<script>alert('Success " + dowhat + "'); location.href='/board/list';</script>");
        } else {
            writer.println("<script>alert('Fail " + dowhat + "'); location.href='/board/list';</script>");
        }
    }
}
