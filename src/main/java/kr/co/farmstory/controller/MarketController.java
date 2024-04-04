package kr.co.farmstory.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
    public String list(Model model, Integer pageNum, Integer pageSize, String cate){

        log.info("cate:"+cate);
        model.addAttribute("cate", cate);

        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 20 : pageSize;

        PageHelper.startPage(pageNum, pageSize);
        List<ProductDTO> products = productService.selectProducts(cate);

        PageInfo<ProductDTO> productPage = new PageInfo<>(products);
        log.info("productPage : "+productPage);
        model.addAttribute("productPage", productPage);

        model.addAttribute("products",products);
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

        List<CartDTO> cartDTOList = cartService.selectCartList(pno, uid);
        for(CartDTO cartDTO1 : cartDTOList){
            log.info(cartDTO1.toString());
        }

        model.addAttribute(cartDTOList);

        return "/market/cart";
    }

    @GetMapping("/market/order")
    public String order(Principal principal, int pno, int count){

        return "/market/order";
    }

}
