package org.example.pojo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.pojo.BasePage;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageArticleForm {
    @NotNull
    private Integer pageNum;
    @NotNull
    private Integer pageSize;
    private String categoryId;
    private String state;
}
