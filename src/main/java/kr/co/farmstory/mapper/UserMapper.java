package kr.co.farmstory.mapper;

import kr.co.farmstory.dto.TermsDTO;
import kr.co.farmstory.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public TermsDTO selectTerms();

    public void insertUser(UserDTO userDTO);
}
