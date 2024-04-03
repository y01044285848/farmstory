package kr.co.farmstory.mapper;

import kr.co.farmstory.dto.ProductDTO;
import kr.co.farmstory.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {


    public void insertProduct(ProductDTO productDTO);

    public void insertAdmin(UserDTO userDTO);

    public List<ProductDTO> selectProduct();

    // adminIndex 회원 목록 표시
    public List<UserDTO> selectUsers();

}
