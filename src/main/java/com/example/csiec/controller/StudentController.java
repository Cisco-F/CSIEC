package com.example.csiec.controller;

import com.example.csiec.pojo.Result;
import com.example.csiec.pojo.Student;
import com.example.csiec.service.StudentService;
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
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //登录
    @PostMapping("/login")
    public Result login(@RequestBody Student student){
        log.info("用户登录：{}", student);
        Student u = studentService.login(student);

        if(u != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", u.getId());
            claims.put("username", u.getUsername());
            claims.put("password", u.getPassword());
            String jwt = generateJwt(claims);
            return Result.success(jwt);
        }
        return  Result.error("用户名或密码错误！");
    }

    //注册
    @PostMapping("/register")
    public Result register(@RequestBody Student student){
        log.info("注册用户：{}", student);
        return studentService.register(student);
    }
}
