package kr.co.farmstory.service;

import kr.co.farmstory.dto.ArticleDTO;

import kr.co.farmstory.dto.FileDTO;
import kr.co.farmstory.entity.Article;
import kr.co.farmstory.entity.File;
import kr.co.farmstory.mapper.ArticleMapper;
import kr.co.farmstory.repository.ArticleRepository;
import kr.co.farmstory.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import kr.co.farmstory.mapper.CropTalkMapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j @RequiredArgsConstructor @Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final FileRepository fileRepository;

    private final ModelMapper modelMapper;

    private final FileService fileService;

    private final ArticleMapper articleMapper;
    private final CropTalkMapper cropTalkMapper;

    public List<ArticleDTO> selectArticles(String cate){
        return articleMapper.selectArticles(cate);
    }

    public List<ArticleDTO> getRecentArticles(String cate) {
        return cropTalkMapper.selectRecentArticles(cate);
    }

    public void insertArticle(ArticleDTO articleDTO){

        List<FileDTO> files = fileService.fileUpload(articleDTO);

        // 파일 갯수
        articleDTO.setFile(files.size());

        Article article = modelMapper.map(articleDTO, Article.class);
        log.info(article.toString());

        Article savedArticle = articleRepository.save(article);
        log.info("insertArticle : " + savedArticle.toString());

        // 파일 넣기
        for (FileDTO fileDTO : files){
            fileDTO.setAno(savedArticle.getAno());

            File file = modelMapper.map(fileDTO, File.class);

            fileRepository.save(file);
        }
    }

}
