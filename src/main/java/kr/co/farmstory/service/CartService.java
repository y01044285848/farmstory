package kr.co.farmstory.service;


import kr.co.farmstory.dto.CartDTO;
import kr.co.farmstory.entity.Cart;
import kr.co.farmstory.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CartService {

    private final CartMapper cartMapper;

    // 장바구니 항목 삽입
    public ResponseEntity<CartDTO> insertCart(CartDTO cartDTO){

        cartMapper.insertCart(cartDTO);
        return ResponseEntity.ok().body(cartDTO);
    }

    // 장바구니 리스트 출력
    public List<CartDTO> selectCartList (int pno, String uid){
        return  cartMapper.selectCartList(pno, uid);
    }

}











