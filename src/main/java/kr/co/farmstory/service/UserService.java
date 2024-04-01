package kr.co.farmstory.service;

import kr.co.farmstory.dto.TermsDTO;
import kr.co.farmstory.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;

    public TermsDTO selectTerms(){
        return userMapper.selectTerms();
    }

}
