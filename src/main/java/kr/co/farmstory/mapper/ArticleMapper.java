package kr.co.farmstory.mapper;

import kr.co.farmstory.dto.ArticleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper
public interface ArticleMapper {
    Page<ArticleDTO> selectAll();
    public List<ArticleDTO> selectArticles(String grp, String cate);
    public List<ArticleDTO> selectArticlesMain(String cate);
}
