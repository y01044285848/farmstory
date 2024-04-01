package kr.co.farmstory.service;

import kr.co.farmstory.dto.TermsDTO;
import kr.co.farmstory.dto.UserDTO;
import kr.co.farmstory.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public TermsDTO selectTerms(){
        return userMapper.selectTerms();
    }

    public void insertUser(UserDTO userDTO){
        String encoded = passwordEncoder.encode(userDTO.getPass());
        userDTO.setPass(encoded);

        userMapper.insertUser(userDTO);
    }

}
