package kr.co.farmstory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityController {

    @GetMapping("/community/notice")
    public String notice(){
        return "/community/notice";
    }

    @GetMapping("/community/menu")
    public String menu(){
        return "/community/menu";
    }

    @GetMapping("/community/chef")
    public String chef(){
        return "/community/chef";
    }

    @GetMapping("/community/qna")
    public String qna(){
        return "/community/qna";
    }

    @GetMapping("/community/faq")
    public String faq(){
        return "/community/faq";
    }

}
