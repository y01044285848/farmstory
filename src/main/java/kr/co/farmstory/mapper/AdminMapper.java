package kr.co.farmstory.mapper;

import kr.co.farmstory.dto.ProductDTO;
import kr.co.farmstory.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    public void insertAdmin(UserDTO userDTO);

    // adminIndex 회원 목록 표시
    public List<UserDTO> adminIdxUsers();

    // adminIndex 상품 목록 표시
    public List<ProductDTO> adminIdxProducts();



    // adminProduct 상품 목록
    public List<ProductDTO> selectProducts();


}
