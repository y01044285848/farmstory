package kr.co.farmstory.service;

import kr.co.farmstory.dto.ProductDTO;
import kr.co.farmstory.dto.UserDTO;
import kr.co.farmstory.entity.User;
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

    // adminIndex 회원 현황 출력
    public List<UserDTO> adminIdxUsers(){
        return adminMapper.adminIdxUsers();
    }

    // admin.user.list 출력
    public List<UserDTO> adminSelectUsers() {
        return adminMapper.adminSelectUsers();
    }

    // admin.user 정보 조회 및 수정
   public UserDTO adminSelectUser(String uid){
        return adminMapper.adminSelectUserByUid(uid);
   }

    // admin.user.modify


    // adminIndex 상품 목록 출력
    public List<ProductDTO> adminIdxProducts() {
        return adminMapper.adminIdxProducts();
    }

    // admin.product.list 출력
    public List<ProductDTO> adminSelectProducts() {
        return adminMapper.adminSelectProducts();
    }




    public void insertAdmin(UserDTO userDTO){
        String encoded = passwordEncoder.encode(userDTO.getPass());
        userDTO.setPass(encoded);
        adminMapper.insertAdmin(userDTO);
    }


}
