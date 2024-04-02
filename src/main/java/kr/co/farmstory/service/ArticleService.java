package kr.co.farmstory.service;

import kr.co.farmstory.dto.ArticleDTO;
import kr.co.farmstory.mapper.CropTalkMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.dialect.SelectItemReferenceStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ArticleService {

    private final CropTalkMapper cropTalkMapper;

    public List<ArticleDTO> getRecentArticles(String cate) {
        return cropTalkMapper.selectRecentArticles(cate);
    }


}
