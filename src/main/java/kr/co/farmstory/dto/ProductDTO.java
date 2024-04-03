package kr.co.farmstory.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pno;

    private String uid;
    private String cate;
    private String pname;

    @CreationTimestamp
    private LocalDateTime rdate;

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
