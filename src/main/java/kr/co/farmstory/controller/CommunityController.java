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
//import java.util.ArrayList;
//import java.util.List;
//
//@Slf4j @Controller @RequiredArgsConstructor
//public class CommunityController {
//
//    private final ArticleService articleService;
//
//    @GetMapping("/community/notice")
//    public String notice(Model model, String cate, Integer pageNum, Integer pageSize){
//
//        cate = "notice";
//
//        // 페이지 값을 기본으로 1, 사이즈를 10으로 설정
//        pageNum = pageNum == null ? 1 : pageNum;
//        pageSize = pageSize == null ? 10 : pageSize;
//
//        // PageHelper를 사용하여 페이징 시작 (1~10까지)
//        PageHelper.startPage(pageNum, pageSize);
//
//        List<ArticleDTO> articles = articleService.selectArticles(cate);
//
//        PageInfo<ArticleDTO> articlesPage = new PageInfo<>(articles);
//        log.info(articlesPage.getPages()+"");
//        int lastPage = (pageNum/11)*10+10;
//        if(lastPage > articlesPage.getPages()){
//            lastPage = articlesPage.getPages();
//        }
//        articlesPage.setNavigateFirstPage((pageNum/11)*10+1);
//        articlesPage.setNavigateLastPage(lastPage);
//
//        log.info("selectArticlePage" + articlesPage);
//
//        model.addAttribute("articles", articles);
//        model.addAttribute("articlePage", articlesPage);
//
//        return "/community/notice";
//    }
//
//    @GetMapping("/community/menu")
//    public String menu(Model model, String cate, Integer pageNum, Integer pageSize){
//        cate = "menu";
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
//        return "/community/menu";
//    }
//
//    @GetMapping("/community/chef")
//    public String chef(Model model, String cate, Integer pageNum, Integer pageSize){
//        cate = "chef";
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
//        return "/community/chef";
//    }
//
//    @GetMapping("/community/qna")
//    public String qna(Model model, String cate, Integer pageNum, Integer pageSize){
//        cate = "qna";
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
//        return "/community/qna";
//    }
//
//    @GetMapping("/community/faq")
//    public String faq(Model model, String cate, Integer pageNum, Integer pageSize){
//        cate = "faq";
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
//        return "/community/faq";
//    }
//
//}
