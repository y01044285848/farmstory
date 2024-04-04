package kr.co.farmstory.service;


import kr.co.farmstory.dto.CartDTO;
import kr.co.farmstory.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CartService {

    private final CartMapper cartMapper;

    public void insertCart(CartDTO cartDTO){

        cartMapper.insertCart(cartDTO);
    }
}











