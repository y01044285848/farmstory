package kr.co.farmstory.mapper;

import kr.co.farmstory.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {

    public void insertCart(CartDTO cartDTO);
    
    // 장바구니 리스트
    public List<CartDTO> selectCartList(int pno, String uid);

    // 장바구니 리스트 삭제
    public void deleteCartProducts(int pno);

}
