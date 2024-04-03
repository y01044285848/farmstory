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
}
