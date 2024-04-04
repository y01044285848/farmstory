package kr.co.farmstory.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.co.farmstory.dto.ImgDTO;
import kr.co.farmstory.dto.ProductDTO;
import kr.co.farmstory.dto.UserDTO;
import kr.co.farmstory.entity.Product;
import kr.co.farmstory.service.AdminService;
import kr.co.farmstory.service.ImgService;
import kr.co.farmstory.service.ProductService;
import kr.co.farmstory.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AdminController {

    private final AdminService adminService;

    private final ImgService imgService;

    private final UserService userService;


    @GetMapping(value = {"/admin","/admin/index"})
    public String admin(Model model){

        return "/admin/index";
    }

    @GetMapping("/admin/user/list")
    public String userlist(){
        return "/admin/user/list";
    }

    @GetMapping("/admin/user/register")
    public String adminReg(){
        return "/admin/user/register";
    }

    @PostMapping("/admin/user/register")
    public String regAdmin(HttpServletRequest req, UserDTO userDTO) {

        String regIp = req.getRemoteAddr();
        userDTO.setRegip(regIp);

        log.info(userDTO.getRole());
        adminService.insertAdmin(userDTO);
        log.info(userDTO.toString());

        return "redirect:/user/login?success=200";

    }

    @ResponseBody
    @GetMapping("/admin/user/{type}/{value}")
    public ResponseEntity<?> checkUser(HttpSession session,
                                       @PathVariable("type") String type,
                                       @PathVariable("value") String value) {
        int count = userService.selectCountUser(type, value);
        log.info("count :" + count);

        // 중복 없으면 이메일 인증코드 발송
        if(count == 0 && type.equals("email")) {
            log.info("email : " + value);
            userService.sendEmailConde(session, value);
        }

        // Json 생성
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("result", count);

        return ResponseEntity.ok().body(resultMap);

    }

    // 이메일 인증 코드 검사
    @ResponseBody
    @GetMapping("/admin/email/{code}")
    public ResponseEntity<?> checkEmail(HttpSession session, @PathVariable("code") String code) {

        String sessionCode = (String) session.getAttribute("code");

        if(sessionCode.equals(code)) {
            // Json 생성
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("result", true);

            return ResponseEntity.ok().body(resultMap);
        }else{
            // Json 생성
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("result", false);

            return ResponseEntity.ok().body(resultMap);
        }

    }

    @GetMapping("/admin/product/list")
    public String productlist(Model model){

        return "/admin/product/list";
    }

    @GetMapping("/admin/product/register")
    public String productRegister(){
        return "/admin/product/register";
    }

    @PostMapping("/admin/product/register")
    public String productRegister(ProductDTO productDTO,
                                  @RequestParam("imgMain") MultipartFile fileA,
                                  @RequestParam("imgSub1") MultipartFile fileB,
                                  @RequestParam("imgSub2") MultipartFile fileC){

        log.info(""+productDTO);

        List<MultipartFile> files = new ArrayList<>();
        files.add(fileA);
        files.add(fileB);
        files.add(fileC);

        ImgDTO imgDTO = new ImgDTO();

        imgDTO.setPno(productDTO.getPno());
        imgDTO.setFiles(files);


        imgService.imgUpload(imgDTO, productDTO.getCate());
        imgService.insertImg(imgDTO);

        return "redirect:/admin/product/register?success=200";
    }

    @GetMapping("/admin/order/list")
    public String orderlist(){
        return "/admin/order/list";
    }
}
