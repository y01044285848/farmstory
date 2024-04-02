package kr.co.farmstory.controller;

import kr.co.farmstory.dto.ProductDTO;
import kr.co.farmstory.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller @RequiredArgsConstructor
public class MarketController {

    private final ProductService productService;

    @GetMapping("/market/list")
    public String list(Model model){
        List<ProductDTO> products = productService.selectProducts();
        model.addAttribute("products",products);

        return "/market/list";
    }

    @GetMapping("/market/view")
    public String view(){
        return "/market/view";
    }

    @GetMapping("/market/cart")
    public String cart(){
        return "/market/cart";
    }
    @GetMapping("/market/order")
    public String order(){
        return "/market/order";
    }

}
