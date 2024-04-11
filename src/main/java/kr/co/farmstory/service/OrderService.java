package kr.co.farmstory.service;

import kr.co.farmstory.dto.OrderDTO;
import kr.co.farmstory.mapper.CartMapper;
import kr.co.farmstory.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final CartMapper cartMapper;
    private final OrderMapper orderMapper;

    //주문입력
    public void insertOrder(OrderDTO orderDTO){
        cartMapper.insertOrder(orderDTO);
    }

    // 사용자 주문 조회
    public List<OrderDTO> selectOrderlist(){
        return orderMapper.selectOrderlist();
    }


}
