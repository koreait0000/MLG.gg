package com.gg.mlg.home;

import com.gg.mlg.user.UserService;
import com.gg.mlg.user.model.UserEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService service;

    @GetMapping("")
    public String home(){
        return "home";
    }
    @GetMapping("lolhome")
    public String lolhome(Model model) throws IOException {
        List<String> hrefList = new ArrayList();
        List<String> ImgList = new ArrayList();
        List<String> titleList = new ArrayList();
        List<String> writerList = new ArrayList();
        String url = "https://www.google.com/search?q="+"롤신챔프"+"+%EC%9C%A0%ED%8A%9C%EB%B8%8C&sxsrf=ALeKk01eqJ-QQtPbqLXUjxiIRUT3UneyOQ:1626873181915&source=lnms&tbm=vid&sa=X&ved=2ahUKEwi81ejwnvTxAhURxYsBHTYBBWgQ_AUoAXoECAEQAw&biw=1286&bih=788";
        Document doc = Jsoup.connect(url).get();
        Elements el = doc.select("a.rGhul");
        String[] cnt = ((doc.select("div.ij69rd.UHe5G")).text().split(" ")); //조회수
        for (Element e:el) {
            hrefList.add(e.attr("href"));
            Document doc2 = Jsoup.connect(e.attr("href")).get();
            ImgList.add(doc2.select("link[itemprop=thumbnailUrl]").attr("href")); //썸네일
            titleList.add(doc2.title().substring(0,doc2.title().length()-10)); //제목
            writerList.add(doc2.select("link[itemprop=name]").attr("content")); //작성자
        }
        model.addAttribute("hrefList",hrefList);
        model.addAttribute("ImgList",ImgList);
        model.addAttribute("titleList",titleList);
        model.addAttribute("writerList",writerList);
        model.addAttribute("cntList",cnt);
        return "temp/home";
    }

}
