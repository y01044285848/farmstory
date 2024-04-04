package kr.co.farmstory.controller;

import kr.co.farmstory.dto.CartDTO;
import kr.co.farmstory.dto.ProductDTO;
import kr.co.farmstory.dto.UserDTO;
import kr.co.farmstory.mapper.CartMapper;
import kr.co.farmstory.service.CartService;
import kr.co.farmstory.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Controller @RequiredArgsConstructor
public class MarketController {

    private final ProductService productService;
    private final CartService cartService;

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
    public String view(Model model, Integer pno, CartDTO cartDTO){

        ProductDTO productDTO = productService.findById(pno);
        model.addAttribute(productDTO);

        int pcount = cartDTO.getPcount();
        model.addAttribute(cartDTO);
        log.info("Pcount from cartDTO1 :" + pcount);

        return "/market/view";
    }

    // 장바구니 목록
    @GetMapping("/market/cart")
    public String cart(Principal principal, int pno, @RequestParam int count, Model model){
        log.info(pno+"dd");
        log.info(principal.getName());

        ProductDTO productDTO = productService.findById(pno);
        model.addAttribute("count", count);
        log.info("count:" + count);

        model.addAttribute(productDTO);
        log.info(productDTO.toString());

        String uid = principal.getName();
        model.addAttribute("uid", uid);
        log.info("uid:" + uid);

        CartDTO cartDTO = new CartDTO();
        cartDTO.setUid(uid);
        cartDTO.setPno(pno);
        cartDTO.setPcount(count);
        log.info("uid2:" + uid);
        log.info("pno:" + pno);
        model.addAttribute(cartDTO);

        cartService.insertCart(cartDTO);
        log.info("insertCart: " + cartDTO);


        return "/market/cart";
    }

    @GetMapping("/market/order")
    public String order(){
        return "/market/order";
    }

}
