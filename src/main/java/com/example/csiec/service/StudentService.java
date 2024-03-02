package com.example.csiec.service;

import com.example.csiec.pojo.Result;
import com.example.csiec.pojo.Student;

public interface StudentService {
    //登录
    Student login(Student student);

    Result register(Student student);
}
