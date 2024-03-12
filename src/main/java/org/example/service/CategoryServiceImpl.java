package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.pojo.form.UpdateCategoryForm;
import org.example.mapper.CategoryMapper;
import org.example.pojo.entity.Category;
import org.example.util.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryMapper categoryMapper;
    @Override
    public void add(Category category) {
        Integer id = ThreadLocalUtil.getIdFromThreadLocal();
        category.setCreateUser(id);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.add(category);
    }

    @Override
    public List<Category> list() {
        return categoryMapper.list(ThreadLocalUtil.getIdFromThreadLocal());
    }

    @Override
    public Category detail(Integer id) {
        return categoryMapper.selectOne(id);
    }

    @Override
    public void update(UpdateCategoryForm form) {
        categoryMapper.updateCategory(form);
    }

    @Override
    public void delete(Integer id) {
        categoryMapper.delete(id);
    }
}
