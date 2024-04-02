package kr.co.farmstory.service;

import kr.co.farmstory.dto.ArticleDTO;

import kr.co.farmstory.mapper.ArticleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import kr.co.farmstory.mapper.CropTalkMapper;

import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j @RequiredArgsConstructor @Service
public class ArticleService {

    private final ArticleMapper articleMapper;
    private final CropTalkMapper cropTalkMapper;

    public List<ArticleDTO> selectArticles(String cate){
        return articleMapper.selectArticles(cate);
    }

    public List<ArticleDTO> getRecentArticles(String cate) {
        return cropTalkMapper.selectRecentArticles(cate);
    }


}
