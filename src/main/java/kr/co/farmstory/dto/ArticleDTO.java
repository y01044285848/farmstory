package kr.co.farmstory.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDTO {

    private int ano;
    private String uid;
    private int parent;
    private int comment;
    private String cate;
    private String title;
    private String content;
    private int hit;
    private String regip;
    private LocalDateTime rdate;
    private int file;


}
