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

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CartController {

    private final CartService cartService;

    @PostMapping("cart/insert")
    public ResponseEntity<CartDTO> insertCart(@RequestBody CartDTO cartDTO){
        log.info("받음");
        log.info(cartDTO.toString());

        int pno = cartDTO.getPno();
        List<CartDTO> existingCart = cartService.getCartByPno(cartDTO.getUid());
        for (CartDTO cartDTO1 : existingCart) {
            if(cartDTO1.getPno() == pno){
                cartService.updateCart(cartDTO.getPcount());
                log.info("존재하는 pno: ");
                return  ResponseEntity.ok().body(cartDTO1);
            }
        }
        cartService.insertCart(cartDTO);
        return  ResponseEntity.ok().body(cartDTO);
    }

}
