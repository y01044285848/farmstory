package kr.co.farmstory.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import kr.co.farmstory.dto.CartDTO;

import kr.co.farmstory.dto.ProductDTO;
import kr.co.farmstory.dto.UserDTO;
import kr.co.farmstory.entity.Cart;
import kr.co.farmstory.mapper.CartMapper;
import kr.co.farmstory.service.CartService;
import kr.co.farmstory.service.ProductService;
import kr.co.farmstory.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    private final UserService userService;

    @GetMapping("/market/list")
    public String list(Model model, Integer pageNum, Integer pageSize, String cate){

        log.info("cate:"+cate);
        model.addAttribute("cate", cate);

        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 20 : pageSize;

        PageHelper.startPage(pageNum, pageSize);
        List<ProductDTO> products = productService.selectProducts(cate);

        PageInfo<ProductDTO> productPage = new PageInfo<>(products);

        log.info(productPage.getPages()+"");

        int lastPage = (pageNum/11)*10+10;

        if(lastPage > productPage.getPages()){
            lastPage = productPage.getPages();
        }
        productPage.setNavigateFirstPage((pageNum/11)*10+1);
        productPage.setNavigateLastPage(lastPage);

        log.info("selectProductPage" + productPage);

        model.addAttribute("productPage", productPage);
        model.addAttribute("products",products);

        return "/market/list";
    }

    // 상품 상세보기
    @GetMapping("/market/view")

    public String view(Model model, Integer pno, CartDTO cartDTO){


        ProductDTO productDTO = productService.findById(pno);
        model.addAttribute(productDTO);

        int pcount = cartDTO.getPcount();
        model.addAttribute(pcount);
        log.info("Pcount from cartDTO1 :" + pcount);

        return "/market/view";
    }


    // 장바구니 목록
    @PostMapping("/market/cart")
    public String cart(Principal principal, CartDTO cartDTO, Model model){
        log.info(cartDTO.getPno()+"dd");
        log.info(principal.getName());

        ProductDTO productDTO = productService.findById(cartDTO.getPno());
        model.addAttribute("count", cartDTO.getPcount());
        log.info("count:" + cartDTO.getPcount());

        model.addAttribute(productDTO);
        log.info(productDTO.toString());

        String uid = principal.getName();

        cartDTO.setUid(uid);
        log.info("uid:" + uid);

        model.addAttribute(cartDTO);

        //cartService.insertCart(cartDTO);
        log.info("insertCart: " + cartDTO);

        List<CartDTO> cartDTOList = cartService.selectCartList(cartDTO.getPno(), uid);
        for(CartDTO cartDTO1 : cartDTOList){
            log.info(cartDTO1.toString());
        }

        model.addAttribute(cartDTOList);

        return "/market/cart";
    }


    @PostMapping(value = "/market/cart/delete")
    public String deleteCartList(Principal principal, @RequestParam("pno") List<Integer> pnos, CartDTO cartDTO, Model model) {

        String uid = principal.getName();
        log.info("uid :" + uid);

        List<CartDTO> cartDTOList = cartService.selectCartList(cartDTO.getPno(), uid);
        for(CartDTO cartDTO1 : cartDTOList){
            log.info("selectCartList : " + cartDTO1);
        }

        model.addAttribute(cartDTOList);
        log.info("cartList : " + cartDTOList);


        // 선택한 상품 삭제
        for (Integer pno : pnos) {
            cartService.deleteCartList(pno);
        }
        log.info("deletePnos : " + pnos);


        return "redirect:/market/cart";
    }

    @GetMapping("/market/cart")
    public String showCart(Model model, Principal principal, CartDTO cartDTO) {
        String uid = principal.getName();
        log.info("uid : " + uid);

        List<CartDTO> cartDTOList = cartService.selectCartList(cartDTO.getPno(), uid);
        for(CartDTO cartDTO1 : cartDTOList){
            log.info("cartDTO1 : " + cartDTO1);
        }

        ProductDTO productDTO = productService.findById(cartDTO.getPno());
        model.addAttribute("price", productDTO.getPrice());
        log.info("price:" + productDTO.getPrice());

        model.addAttribute("productDTO", productDTO);
        log.info(productDTO.toString());

        model.addAttribute(cartDTOList);
        log.info("cartDTOList: " + cartDTOList);

        return "/market/cart";
    }



    @PostMapping("/market/order")
    public String order(CartDTO cartDTO, Model model){


        UserDTO userDTO = userService.selectUser(cartDTO.getUid());
        log.info(userDTO.toString());
        List<CartDTO> cartDTOList = cartService.selectCartList2(cartDTO.getUid());
        for(CartDTO cartDTO1 : cartDTOList){
            log.info(cartDTO1.toString());
        }
        model.addAttribute(userDTO);
        return "/market/order";
    }

}
