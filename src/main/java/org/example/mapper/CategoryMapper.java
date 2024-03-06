package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.form.UpdateCategoryForm;
import org.example.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    @Insert("insert into category (category_name, category_alias, create_user, create_time, update_time) " +
            "values (#{categoryName}, #{categoryAlias}, #{createUser}, #{createTime}, #{updateTime})")
    void add(Category category);

    @Select("select * from category where create_user = #{id}")
    List<Category> list(Integer id);

    @Select("select * from category where id = #{id}")
    Category selectOne(Integer id);

    @Update("update category " +
            "set category_name = #{categoryName}, category_alias = #{categoryAlias}, update_time = now() " +
            "where id = #{id}")
    void updateCategory(UpdateCategoryForm form);

    @Delete("delete from category where id = #{id}")
    void delete(Integer id);
}
