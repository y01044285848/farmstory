package kr.co.farmstory.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.farmstory.dto.ProductDTO;
import kr.co.farmstory.dto.UserDTO;
import kr.co.farmstory.service.ImgService;
import kr.co.farmstory.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.PrivateKey;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AdminController {

    private final ProductService productService;

    @GetMapping("/admin/index")
    public String admin(){
        return "/admin/index";
    }

    @GetMapping("/admin/user/list")
    public String userlist(){
        return "/admin/user/list";
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
    public String productregister(ProductDTO productDTO){




        log.info(""+productDTO);



        productService.insertProduct(productDTO);



        return "redirect:/admin/product/register?success=200";
    }

    @GetMapping("/admin/order/list")
    public String orderlist(){
        return "/admin/order/list";
    }
}
