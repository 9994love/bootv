package org.example.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.example.form.LoginForm;
import org.example.pojo.Result;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@Validated
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 注册
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @PostMapping("register")
    public Result register(@NotBlank @Size(min = 5, max = 16) String username,
                           @NotBlank @Size(min = 5, max = 16) String password){
        userService.register(username, password);
            return Result.success();
    }

    /**
     * 登录
     * @return 登录令牌
     */
    @PostMapping("login")
    public Result<String> login(@RequestBody @Valid LoginForm loginForm) {
        return Result.success(userService.login(loginForm));
    }
}
