package org.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.pojo.PageBean;
import org.example.pojo.entity.Article;
import org.example.pojo.form.AddArticleForm;
import org.example.pojo.entity.Result;
import org.example.pojo.form.PageArticleForm;
import org.example.service.ArticleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("article")
@RequiredArgsConstructor
@Validated
public class ArticleController {

    private final ArticleService articleService;

    /**
     * 新增文章
     */
    @PostMapping("add")
    public Result add(@RequestBody @Valid AddArticleForm form){
        articleService.add(form);
        return Result.success();
    }

    @PostMapping("page")
    public Result<PageBean<Article>> page(@RequestBody @Valid PageArticleForm form){
        return Result.success(articleService.pageByCategoryIdAndState(form));
    }
}
