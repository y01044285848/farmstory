package kr.co.farmstory.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.farmstory.dto.TermsDTO;
import kr.co.farmstory.dto.UserDTO;
import kr.co.farmstory.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;


    @GetMapping("/user/login")
    public String login(){
        return "/user/login";
    }

    @GetMapping("/user/register")
    public String register() {
        return "/user/register";
    }

    @PostMapping("/user/register")
    public String registerUser(HttpServletRequest req, UserDTO userDTO) {

        String regIp = req.getRemoteAddr();
        userDTO.setRegIp(regIp);

        return "redirect:/user/register?success=200";
    }


    @GetMapping("/user/terms")
    public String terms(Model model){

        TermsDTO termsDTO = userService.selectTerms();
        model.addAttribute(termsDTO);

        return "/user/terms";
    }
}
