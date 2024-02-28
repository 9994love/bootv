package org.example.controller;

import org.example.pojo.Result;
import org.example.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {



    @PostMapping("register")
    public Result<User> register(@RequestParam(value = "username") String username, String password){
        //查询用户

        //注册
    }
}
