package org.example.service;

import org.example.pojo.PageBean;
import org.example.pojo.entity.Article;
import org.example.pojo.form.AddArticleForm;
import org.example.pojo.form.PageArticleForm;

public interface ArticleService {
    void add(AddArticleForm form);

    PageBean<Article> pageByCategoryIdAndState(PageArticleForm form);
}
