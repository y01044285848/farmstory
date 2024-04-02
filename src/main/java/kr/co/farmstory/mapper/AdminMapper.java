package kr.co.farmstory.mapper;

import kr.co.farmstory.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    public void insertProduct(ProductDTO productDTO);

}
