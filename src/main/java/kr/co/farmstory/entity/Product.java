package kr.co.farmstory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
@Entity @Table(name = "product")
public class Product {

    @Id
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