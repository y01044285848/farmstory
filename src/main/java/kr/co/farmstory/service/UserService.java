package kr.co.farmstory.service;

import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpSession;
import kr.co.farmstory.dto.TermsDTO;
import kr.co.farmstory.dto.UserDTO;
import kr.co.farmstory.mapper.AdminMapper;
import kr.co.farmstory.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    private final AdminMapper adminMapper;
    private final PasswordEncoder passwordEncoder;

    // JavaMailSender 주입
    private final JavaMailSender javaMailSender;

    public TermsDTO selectTerms(){
        return userMapper.selectTerms();
    }

    public void insertUser(UserDTO userDTO){
        String encoded = passwordEncoder.encode(userDTO.getPass());
        userDTO.setPass(encoded);

        userMapper.insertUser(userDTO);
    }

    /* adminIndex 회원목록 표시
    public List<UserDTO> selectUsers(){
        return adminMapper.selectUsers();
    }
    */

    public int selectCountUser(String type, String value) {
        return userMapper.selectCountUser(type, value);
    }

    @Value("dpsk08270@gmail.com")
    private String sender;
    // 🎈이메일 인증코드 전송
    public void sendEmailConde(HttpSession session, String receiver){
        log.info("sender : " + sender);

        // MimeMessage 생성
        MimeMessage message = javaMailSender.createMimeMessage();

        // 인증코드 생성 후 세션 저장
        int code = ThreadLocalRandom.current().nextInt(100000, 1000000);
        session.setAttribute("code", String.valueOf(code));

        log.info("code : " + code);

        String title = "🌻Farmstory 인증코드 입니다.";
        String content = "<h1>인증코드는" +  code + "입니다.</h1>";

        try {
            message.setFrom(new InternetAddress(sender, "보내는 사람", "UTF-8"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            message.setSubject(title);
            message.setContent(content, "text/html;charset=UTF-8");

            javaMailSender.send(message);

        } catch(Exception e){
            log.error("sendEmailCode : " + e.getMessage());
        }

    }


}











