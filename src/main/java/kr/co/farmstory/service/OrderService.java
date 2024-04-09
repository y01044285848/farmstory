package kr.co.farmstory.service;

import kr.co.farmstory.dto.OrderDTO;
import kr.co.farmstory.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final CartMapper cartMapper;

    //주문입력
    public void insertOrder(OrderDTO orderDTO){
        cartMapper.insertOrder(orderDTO);
    }


}
