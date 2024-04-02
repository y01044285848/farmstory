package kr.co.farmstory.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
@Entity @Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pno;
    private String cate;
    private String pname;
    private int price;
    private int stock;
    private int delprice;
    private String company;
    private int discount;
    private int point;
    private String etc;
}