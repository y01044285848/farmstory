package kr.co.farmstory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/croptalk/story")
    public String story(){
        return "/croptalk/story";
    }

    @GetMapping("/croptalk/grow")
    public String grow(){
        return "/croptalk/grow";
    }

    @GetMapping("/croptalk/school")
    public String school(){
        return "/croptalk/school";
    }

}
