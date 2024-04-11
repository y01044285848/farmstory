package kr.co.farmstory.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderlistDTO {

    private int Ino;
    private int Ono;
    private String uid;
    private int pno;
    private int pcount;
    private int price;
}
