package org.example.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.example.pojo.PageBean;
import org.example.pojo.entity.Article;
import org.example.pojo.form.AddArticleForm;
import org.example.mapper.ArticleMapper;
import org.example.pojo.form.PageArticleForm;
import org.example.util.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService{

    private final ArticleMapper articleMapper;
    @Override
    public void add(AddArticleForm form) {
        form.setCreateUser(ThreadLocalUtil.getIdFromThreadLocal());
        articleMapper.add(form);
    }

    @Override
    public PageBean<Article> pageByCategoryIdAndState(PageArticleForm form) {
        PageHelper.startPage(form.getPageNum(), form.getPageSize());
        Page<Article> articles = (Page<Article>) articleMapper.pageByCategoryIdAndState(form.getCategoryId(), form.getState(), ThreadLocalUtil.getIdFromThreadLocal());
        PageBean<Article> page = new PageBean<>();
        page.setTotal(articles.getTotal());
        page.setItems(articles.getResult());
        return page;
    }
}
