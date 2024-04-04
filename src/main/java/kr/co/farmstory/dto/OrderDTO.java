package kr.co.farmstory.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {

    private int ono;
    private String uid;
    private int pno;
    private int pcount;
    private LocalDateTime odate;
    private int usepoint;
    
}
