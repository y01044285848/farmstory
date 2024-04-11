package kr.co.farmstory.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderlistDTO {

    private int lno;
    private int ono;
    private String uid;
    private int pno;
    private int pcount;

}
