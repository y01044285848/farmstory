package kr.co.farmstory.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImgDTO {

    private int ino;
    private int pno;
    private MultipartFile img1;
    private MultipartFile img2;
    private MultipartFile img3;

}
