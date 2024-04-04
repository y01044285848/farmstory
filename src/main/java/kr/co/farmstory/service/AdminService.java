package kr.co.farmstory.service;

import kr.co.farmstory.dto.UserDTO;
import kr.co.farmstory.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminMapper adminMapper;
    private final PasswordEncoder passwordEncoder;

    public List<UserDTO> selectUsers(){
        return adminMapper.selectUsers();

    }

    public void insertAdmin(UserDTO userDTO){
        String encoded = passwordEncoder.encode(userDTO.getPass());
        userDTO.setPass(encoded);
        adminMapper.insertAdmin(userDTO);
    }


}
