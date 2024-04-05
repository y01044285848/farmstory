package kr.co.farmstory.controller;

import kr.co.farmstory.dto.CartDTO;
import kr.co.farmstory.entity.Cart;
import kr.co.farmstory.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CartController {

    private final CartService cartService;

    @PostMapping("cart/insert")
    public ResponseEntity<CartDTO> insertCart(@RequestBody CartDTO cartDTO){
        log.info("받음");
        log.info(cartDTO.toString());
        return cartService.insertCart(cartDTO);
    }

}
