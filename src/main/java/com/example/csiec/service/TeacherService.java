package com.example.csiec.service;

import com.example.csiec.pojo.Result;
import com.example.csiec.pojo.Teacher;
import org.springframework.stereotype.Service;

public interface TeacherService {
    Teacher login(Teacher teacher);

    Result register(Teacher teacher);
}
