package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.entity.Article;
import org.example.pojo.form.AddArticleForm;

import java.util.List;

public interface ArticleMapper {
    @Insert("INSERT INTO article " +
            "(title, content, cover_img, state, category_id, create_user, create_time, update_time) " +
            "VALUES (#{title}, #{content}, #{coverImg}, #{state}, #{categoryId}, #{createUser}, now(), now())")
    void add(AddArticleForm form);

    List<Article> pageByCategoryIdAndState(@Param("categoryId") String categoryId, @Param("state") String state, @Param("createUser") Integer createUser);

}
