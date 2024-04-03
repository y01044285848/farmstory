package kr.co.farmstory.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller @Slf4j @RequiredArgsConstructor
public class ArticleController {

    @GetMapping("/article/write")
    public String write(){
        return "/article/write";
    }

    @GetMapping("/article/commuity/notice")
    public String list(String cate){

        return "/board";
    }

    /*
    article/board?group=community&cate=notice
    select * from article
    where group=coummuity and cate=notice;

    article/community
    article/event
    article/croptalk



     */

}
