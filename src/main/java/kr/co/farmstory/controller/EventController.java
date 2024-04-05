//package kr.co.farmstory.controller;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import kr.co.farmstory.dto.ArticleDTO;
//import kr.co.farmstory.service.ArticleService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//@Controller @RequiredArgsConstructor @Slf4j
//public class EventController {
//
//    private final ArticleService articleService;
//    @GetMapping("/event/event")
//    public String event(Model model, String cate, Integer pageNum, Integer pageSize){
//        cate = "event";
//
//        // 페이지 값을 기본으로 1, 사이즈를 10으로 설정
//        pageNum = pageNum == null ? 1 : pageNum;
//        pageSize = pageSize == null ? 10 : pageSize;
//
//        // PageHelper를 사용하여 페이징 시작 (1~10까지)
//        PageHelper.startPage(pageNum, pageSize);
//        List<ArticleDTO> articles = articleService.selectArticles(cate);
//
//        PageInfo<ArticleDTO> articlesPage = new PageInfo<>(articles);
//        log.info("selectArticlePage" + articlesPage);
//
//        model.addAttribute("articles", articles);
//        model.addAttribute("articlePage", articlesPage);
//
//        articleService.selectArticles(cate);
//        return "/event/event";
//    }
//
//}
