package kr.co.farmstory.dto;

import lombok.*;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductDTO {

    private int pno;
    private String cate;
    private String pname;
    private int price;

    @Builder.Default
    private int stock =0;

    @Builder.Default
    private int delprice=0;
    private String company;

    @Builder.Default
    private int discount=0;

    @Builder.Default
    private int point=0;
    private String etc;
}
