package org.example.service;

import org.example.form.UpdateCategoryForm;
import org.example.pojo.Category;

import java.util.List;

public interface CategoryService {
    void add(Category category);

    List<Category> list();

    Category detail(Integer id);

    void update(UpdateCategoryForm form);

    void delete(Integer id);
}
