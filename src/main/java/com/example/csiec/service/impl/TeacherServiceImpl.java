package com.example.csiec.service.impl;

import com.example.csiec.mapper.TeacherMapper;
import com.example.csiec.pojo.Result;
import com.example.csiec.pojo.Teacher;
import com.example.csiec.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher login(Teacher teacher) {
        return teacherMapper.login(teacher);
    }

    @Override
    public Result register(Teacher teacher) {
        Teacher t1 = teacherMapper.getByAccount(teacher.getAccount());
        Teacher t2 = teacherMapper.getByUsername(teacher.getUsername());
        if(t1 != null) {
            return Result.error("账号已存在！");
        } else if(t2 != null){
            return Result.error("用户名已存在！");
        } else {
            teacherMapper.register(teacher);
            return Result.success();
        }
    }
}
