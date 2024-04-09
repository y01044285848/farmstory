package kr.co.farmstory.service;

import kr.co.farmstory.dto.ArticleDTO;
import kr.co.farmstory.entity.Article;
import kr.co.farmstory.mapper.ArticleMapper;
import kr.co.farmstory.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j @RequiredArgsConstructor @Service
public class CommentService {

    private final ModelMapper modelMapper;
    private final ArticleRepository articleRepository;

    public ResponseEntity<Article> insertComment(ArticleDTO articleDTO){
        Article article = modelMapper.map(articleDTO, Article.class);

        Article insertArticle = articleRepository.save(article);
        log.info(insertArticle.toString());

        return ResponseEntity.ok().body(insertArticle);
    }

    public ResponseEntity<List<ArticleDTO>> selectComment(int no){
        List<Article> articleList = articleRepository.findCommentByParent(no);

        List<ArticleDTO> articleDTOs = articleList.stream()
                .map(entity->modelMapper.map(entity, ArticleDTO.class))
                .toList();

        return ResponseEntity.ok().body(articleDTOs);
    }

    public void updateGood(int ano){

        articleRepository.updateGood(ano);
    }

    public void updateHate(int ano){

        articleRepository.updateHate(ano);
    }



}
