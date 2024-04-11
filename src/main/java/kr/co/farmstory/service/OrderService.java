package kr.co.farmstory.service;

import kr.co.farmstory.dto.OrderDTO;
import kr.co.farmstory.dto.OrderlistDTO;
import kr.co.farmstory.entity.Order;
import kr.co.farmstory.entity.Orderlist;
import kr.co.farmstory.entity.Product;
import kr.co.farmstory.mapper.CartMapper;
import kr.co.farmstory.repository.OrderRepository;
import kr.co.farmstory.repository.OrderlistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final CartMapper cartMapper;
    private final OrderlistRepository orderlistRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    //주문입력
    public Order insertOrder(OrderDTO orderDTO){
        Order order = modelMapper.map(orderDTO, Order.class);
        log.info(order.toString());
        Order resultOrder = orderRepository.save(order);

        log.info(resultOrder.toString());

        return resultOrder;
    }

    public void insertOrderList(OrderlistDTO orderlistDTO){
        Orderlist orderlist = modelMapper.map(orderlistDTO, Orderlist.class);
        orderlistRepository.save(orderlist);

        log.info("orderlist : " +orderlist);
    }


}
