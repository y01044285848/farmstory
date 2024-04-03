package kr.co.farmstory.mapper;

import kr.co.farmstory.dto.ProductDTO;
import kr.co.farmstory.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    public void insertAdmin(UserDTO userDTO);
    public void insertProduct(ProductDTO productDTO, String uid);
    public List<ProductDTO> selectProduct();
    public List<UserDTO> selectUsers(String uid);
}
