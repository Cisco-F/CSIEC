package com.example.csiec.controller;

import com.example.csiec.pojo.Result;
import com.example.csiec.pojo.Teacher;
import com.example.csiec.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.example.csiec.utils.JwtUtils.generateJwt;

@Slf4j
@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/login")
    public Result login(@RequestBody Teacher teacher) {
        log.info("用户登录：{}", teacher);
        Teacher u = teacherService.login(teacher);

        if (u != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", u.getId());
            claims.put("username", u.getUsername());
            claims.put("password", u.getPassword());
            String jwt = generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误！");
    }

    @PostMapping("/register")
    public Result register(@RequestBody Teacher teacher){
        log.info("注册用户：{}", teacher);
        return teacherService.register(teacher);
    }
}
