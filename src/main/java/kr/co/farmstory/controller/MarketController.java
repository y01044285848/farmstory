package kr.co.farmstory.controller;

import kr.co.farmstory.dto.ProductDTO;
import kr.co.farmstory.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Controller @RequiredArgsConstructor
public class MarketController {

    private final ProductService productService;

    @GetMapping("/market/list")
    public String list(Model model){
        List<ProductDTO> products = productService.selectProducts();
        List<ProductDTO> modelProducts = new ArrayList<>();
        Map<String, String> trans = new HashMap<>();
        trans.put("fruit","과일");
        trans.put("vegetable","야채");
        trans.put("grains","곡류");
        model.addAttribute("trans", trans);
        for(ProductDTO productDTO : products){
            productDTO.setCate(trans.get(productDTO.getCate()));
            modelProducts.add(productDTO);
        }
        model.addAttribute("products",modelProducts);

        return "/market/list";
    }

    @GetMapping("/market/view")
    public String view(Model model, Integer pno){

        ProductDTO productDTO = productService.findById(pno);

        model.addAttribute(productDTO);
        return "/market/view";
    }

    @GetMapping("/market/cart")
    public String cart(int pno){
        log.info(pno+"dd");
        return "/market/cart";
    }
    @GetMapping("/market/order")
    public String order(){
        return "/market/order";
    }

}
