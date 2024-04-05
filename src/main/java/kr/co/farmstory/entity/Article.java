package kr.co.farmstory.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ano;

    private String uid;
    private int parent;

    @Builder.Default
    private int comment = 0;

    private String cate;
    private String title;
    private String content;

    @Builder.Default
    private int hit = 0;

    private String regip;
    private String grp;

    @CreationTimestamp
    private LocalDateTime rdate;

    @Builder.Default
    private int file = 0;

}
