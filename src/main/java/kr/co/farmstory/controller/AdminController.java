package kr.co.farmstory.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.co.farmstory.dto.ProductDTO;
import kr.co.farmstory.dto.UserDTO;
import kr.co.farmstory.service.ProductService;
import kr.co.farmstory.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AdminController {

    private final UserService userService;
    private final ProductService productService;

    @GetMapping(value = {"/admin/","/admin/index"})
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
        userDTO.setRegIp(regIp);

        userDTO.setRole("USER");
        userService.insertUser(userDTO);
        log.info(userDTO.toString());

        return "redirect: /admin/user/login?success=200";

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

        List<ProductDTO> products = productService.selectProducts();
        model.addAttribute("products", products);

        return "/admin/product/list";
    }

    @GetMapping("/admin/product/register")
    public String productregister(){
        return "/admin/product/register";
    }

    @PostMapping("/admin/product/register")
    public String productregister(HttpServletRequest req, ProductDTO productDTO){

        log.info(""+productDTO);

        productService.insertProduct(productDTO);



        return "/admin/product/register";
    }

    @GetMapping("/admin/order/list")
    public String orderlist(){
        return "/admin/order/list";
    }
}
