package kr.co.farmstory.mapper;

import kr.co.farmstory.dto.ProductDTO;
import kr.co.farmstory.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    public void insertProduct(ProductDTO productDTO, String uid);
    public List<ProductDTO> selectProduct();
    
    // adminIndex 상품 목록 표시
    public List<ProductDTO> indexProducts();

    // adminIndex 회원 목록 표시
    public List<UserDTO> selectUsers();

}
