package org.example.form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAvatarForm
{
    private Integer id;
    @NotBlank
    private String avatarUrl;

    private LocalDateTime updateTime;
}
