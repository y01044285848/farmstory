package kr.co.farmstory.repository;

import kr.co.farmstory.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    public List<Article> findCommentByParent(int parent);
}
