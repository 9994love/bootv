package org.example.form;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginForm {

    @NotBlank
    @Size(min = 5, max = 16)
    private String username;
    @NotBlank
    @Size(min = 5, max = 16)
    private String password;
}
