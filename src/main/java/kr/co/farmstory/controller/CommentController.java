package kr.co.farmstory.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.farmstory.dto.ArticleDTO;
import kr.co.farmstory.entity.Article;
import kr.co.farmstory.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j @RequiredArgsConstructor @RestController
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comment/{no}")
    public ResponseEntity<List<ArticleDTO>> selectComment(@PathVariable("no") int no){
        return commentService.selectComment(no);
    }


    @PostMapping("/comment")
    public ResponseEntity<Article> insertComment(@RequestBody ArticleDTO articleDTO, HttpServletRequest req){
        String regip = req.getRemoteAddr();
        articleDTO.setRegip(regip);
        log.info("insertComment : " + articleDTO);

        return commentService.insertComment(articleDTO);
    }

}
