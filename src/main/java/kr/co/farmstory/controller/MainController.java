package kr.co.farmstory.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {



    @GetMapping(value = {"/","/index"})
    public String index(){
        return "/index";
    }

    @GetMapping("/test")
    public String test(){
        return "/test";
    }

}
