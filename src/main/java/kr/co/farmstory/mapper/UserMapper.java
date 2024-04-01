package kr.co.farmstory.mapper;

import kr.co.farmstory.dto.TermsDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public TermsDTO selectTerms();

}
