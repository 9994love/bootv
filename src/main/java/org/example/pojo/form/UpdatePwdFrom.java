package org.example.pojo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePwdFrom {
    private Integer id;
    @NotBlank
    private String old_pwd;
    @Size(min = 5, max = 16)
    private String new_pwd;
    @Size(min = 5, max = 16)
    private String re_pwd;
    private LocalDateTime updateTime;
}
