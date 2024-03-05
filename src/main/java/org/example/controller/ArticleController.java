package org.example.controller;

import org.example.pojo.Result;
import org.example.util.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.Map;

@RestController
@RequestMapping("article")
public class ArticleController {

    @PostMapping("list")
    public Result<String> list(){
        return Result.success("sd");
    }
}
