package com.example.csiec.service.impl;

import com.example.csiec.mapper.StudentMapper;
import com.example.csiec.pojo.Result;
import com.example.csiec.pojo.Student;
import com.example.csiec.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    //登录
    @Override
    public Student login(Student student) {
        return studentMapper.login(student);
    }

    @Override
    public Result register(Student student) {
        //账号重复
        Student u1 = studentMapper.getByAccount(student.getAccount());
        Student u2 = studentMapper.getByUsername(student.getUsername());
        if(u1 != null) {
            return Result.error("账号已存在！");
        } else if(u2 != null){
            return Result.error("用户名已存在！");
        } else {
            studentMapper.register(student);
            return Result.success();
        }
    }
}
