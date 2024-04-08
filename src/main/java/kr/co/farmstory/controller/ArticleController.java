package kr.co.farmstory.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.servlet.http.HttpServletRequest;
import kr.co.farmstory.dto.ArticleDTO;
import kr.co.farmstory.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller @Slf4j @RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/article/write")
    public String write(String cate, String grp, Model model){
        model.addAttribute("cate", cate);
        model.addAttribute("grp", grp);
        return "/article/write";
    }

    @PostMapping("/article/write")
    public String insertArticle(HttpServletRequest req, ArticleDTO articleDTO){


        String regip = req.getRemoteAddr();
        articleDTO.setRegip(regip);
        log.info("insertArticle : "+articleDTO.toString());

        articleService.insertArticle(articleDTO);

        return "redirect:/article/list?grp="+articleDTO.getGrp()+"&cate="+articleDTO.getCate();
    }

    @GetMapping("/article/list")
    public String articleList(@Param("grp") String grp,
                              @Param("cate") String cate, Model model,
                              Integer pageNum, Integer pageSize){

        log.info("grp : " + grp);
        log.info("cate : " + cate);
        model.addAttribute("grp", grp);
        model.addAttribute("cate", cate);
        // 페이지 값을 기본으로 1, 사이즈를 10으로 설정
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;

        // PageHelper를 사용하여 페이징 시작 (1~10까지)
        PageHelper.startPage(pageNum, pageSize);

        List<ArticleDTO> articles = articleService.selectArticles(grp, cate);

        PageInfo<ArticleDTO> articlesPage = new PageInfo<>(articles);

        log.info(articlesPage.getPages()+"");

        int lastPage = (pageNum/11)*10+10;

        if(lastPage > articlesPage.getPages()){
            lastPage = articlesPage.getPages();
        }
        articlesPage.setNavigateFirstPage((pageNum/11)*10+1);
        articlesPage.setNavigateLastPage(lastPage);

        log.info("selectArticlePage" + articlesPage);

        model.addAttribute("articles", articles);
        model.addAttribute("articlePage", articlesPage);

        return "/article/list";
    }

    @GetMapping("/article/view")
    public String viewArticle(int ano, Model model){

        ArticleDTO articleDTO = articleService.selectArticle(ano);
        model.addAttribute(articleDTO);
        log.info(articleDTO.toString());
        return "/article/view";
    }

    @GetMapping("/article/delete")
    public String deleteArticle(int ano){

        ArticleDTO articleDTO = articleService.selectArticle(ano);
        articleService.deleteArticle(ano);

        return "redirect:/article/list?grp="+articleDTO.getGrp()+"&cate="+articleDTO.getCate();
    }
}
