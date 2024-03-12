package org.example.pojo.form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryForm
{
    @NotBlank
    private String id;

    @NotBlank
    private String categoryName;

    @NotBlank
    private String categoryAlias;
}
