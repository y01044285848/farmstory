package kr.co.farmstory.mapper;

import kr.co.farmstory.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {

    public void insertCart(CartDTO cartDTO);
    public List<CartDTO> selectCartList();

}
