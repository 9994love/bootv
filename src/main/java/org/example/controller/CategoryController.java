package org.example.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Update;
import org.example.form.UpdateCategoryForm;
import org.example.pojo.Category;
import org.example.pojo.Result;
import org.example.service.CategoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("category")
@Validated
public class CategoryController
{

    private final CategoryService categoryService;

    /**
     * 新增文章分类
     */
    @PostMapping("add")
    public Result add(@RequestBody @Valid Category category) {
        categoryService.add(category);
        return Result.success();
    }

    /**
     * 文章分类列表
     */
    @PostMapping("list")
    public Result<List<Category>> list() {
        return Result.success(categoryService.list());
    }

    /**
     * 文章分类详情
     */
    @PostMapping("detail")
    public Result<Category> detail(Integer id) {
        return Result.success(categoryService.detail(id));
    }

    /**
     * 更新文章分类详情
     */
    @PostMapping("update")
    public Result update(@RequestBody @Valid UpdateCategoryForm form) {
        categoryService.update(form);
        return Result.success();
    }

    /**
     * 删除文章分类
     */
    @PostMapping("delete")
    public Result delete(@NotNull Integer id){
        categoryService.delete(id);
        return Result.success();
    }

}
