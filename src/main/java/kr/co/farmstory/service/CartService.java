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

    public List<CartDTO> getCartByPno(String uid){
        return  cartMapper.getCartByPno(uid);
    }

    public int updateCart(int pcount){
        return cartMapper.updateCart(pcount);
    }

    // 장바구니 리스트 출력
    public List<CartDTO> selectCartList (String uid){
        return  cartMapper.selectCartList(uid);
    }
    
    // 장바구니 삭제
    public void deleteCartList(int pno, String uid) {
        cartMapper.deleteCartList(pno, uid);
    }
    public List<CartDTO> selectCartList2 (String uid){
        return  cartMapper.selectCartList2(uid);
    }

}











