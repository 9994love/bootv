package org.example.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.example.form.LoginForm;
import org.example.form.UpdateAvatarForm;
import org.example.form.UpdatePwdFrom;
import org.example.form.UpdateUserForm;
import org.example.pojo.Result;
import org.example.pojo.User;
import org.example.service.UserService;
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

    /**
     * 获取用户详情
     */
    @PostMapping("userInfo")
    public Result<User> userInfo(){
        return Result.success(userService.userInfo());
    }

    /**
     * 更新用户信息
     */
    @PostMapping("update")
    public Result update(@RequestBody @Valid UpdateUserForm updateUserForm){
        userService.update(updateUserForm);
        return Result.success();
    }

    /**
     * 更新用户头像
     */
    @PostMapping("updateAvatar")
    public Result updateAvatar(@RequestBody @Valid UpdateAvatarForm form){
        userService.updateAvatar(form);
        return Result.success();
    }

    /**
     * 更新用户密码
     */
    @PostMapping("updatePwd")
    public Result updatePwd(@RequestBody @Valid UpdatePwdFrom from){
        userService.updatePwd(from);
        return Result.success();
    }
}
