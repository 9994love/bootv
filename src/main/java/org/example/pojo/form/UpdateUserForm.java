package org.example.pojo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserForm {

    private Integer id;
    @NotBlank
    @Size(min = 5, max = 16)
    private String nickName;
    @NotBlank
    @Size(min = 5, max = 16)
    private String email;
    private LocalDateTime updateTime;

}
