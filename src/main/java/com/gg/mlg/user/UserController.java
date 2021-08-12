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
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private LolService lolservice;

    @GetMapping("/home")
    public String home(Principal principal, Model model){
        model.addAttribute("data",0);
        if(principal!=null){
            UserEntity param= new UserEntity();
            param.setUid(principal.getName());
            param=service.selUser(param);
            param.setUpw(null);
            model.addAttribute("data",param);
        }
        return "temp/home";
    }
    @PostMapping("/home")
    public String index(String text, Model model) throws IOException {
        List<String> hrefList = new ArrayList();
        List<String> ImgList = new ArrayList();
        List<String> titleList = new ArrayList();
        List<String> writerList = new ArrayList();
//        Map<String, Object> map = new HashMap<>();
        String url = "https://www.google.com/search?q="+text+"+%EC%9C%A0%ED%8A%9C%EB%B8%8C&sxsrf=ALeKk01eqJ-QQtPbqLXUjxiIRUT3UneyOQ:1626873181915&source=lnms&tbm=vid&sa=X&ved=2ahUKEwi81ejwnvTxAhURxYsBHTYBBWgQ_AUoAXoECAEQAw&biw=1286&bih=788";
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

    @GetMapping("/user/login")
    public String login(HttpServletRequest request) {
        String refer=request.getHeader("Referer");
        if(refer.contains("/user/login")){
            refer="http://localhost:8090/home";
        }
        request.getSession().setAttribute("prevPage",refer);
        return "user/login";
    }

    @GetMapping("/user/join")
    public String join() {
        return "user/join";
    }

    @PostMapping("/user/join")
    public String inJoin(@Parameter UserEntity param) {
        service.inJoin(param);
        return "user/login";
    }

    @ResponseBody
    @PostMapping("/user/follow")
    public int follow(@RequestBody UserEntity param){
        System.out.println(param);
        return service.indelfollow(param);
    }

    @GetMapping("/user/profile")
    public String profile(@Parameter UserEntity param, Model model) {
        UserEntity result=service.selUser(param);
        model.addAttribute("pud", result);
        if(result.getLname()!=null){
        model.addAttribute("pudlol",lolservice.makeProfile(result));
        }
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
