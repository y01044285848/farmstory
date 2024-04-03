package kr.co.farmstory.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.farmstory.dto.ArticleDTO;
import kr.co.farmstory.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller @Slf4j @RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    @GetMapping("/article/write")
    public String write(@RequestParam String cate, Model model){
        model.addAttribute("cate", cate);
        return "/article/write";
    }

    @PostMapping("/article/write/{cate}")
    public String insertArticle(HttpServletRequest req, ArticleDTO articleDTO){
        String regip = req.getRemoteAddr();
        String cate = articleDTO.getCate();
        articleDTO.setRegip(regip);
        log.info(articleDTO.toString());

        articleService.insertArticle(articleDTO);

        return "redirect:/community/"+cate;
    }

    @GetMapping("/article/list")
    public String articleList(String cate){


        return "/article/list";
    }

}
