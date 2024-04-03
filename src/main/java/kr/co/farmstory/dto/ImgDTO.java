package kr.co.farmstory.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImgDTO {

    private int ino;
    private int pno;
    private String img1;
    private String img2;
    private String img3;

}
