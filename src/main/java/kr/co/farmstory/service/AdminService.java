package kr.co.farmstory.service;

import kr.co.farmstory.dto.UserDTO;
import kr.co.farmstory.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminMapper adminMapper;

    public List<UserDTO> selectUsers(String uid){
        return adminMapper.selectUsers(uid);

    }


}
