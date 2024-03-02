package com.example.csiec.mapper;

import com.example.csiec.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {
    //登录
    @Select("select * from student where username = #{username} and password = #{password}")
    Student login(Student student);

    @Select("select * from student where username = #{username}")
    Student getByUsername(String username);

    @Select("select * from student where account = #{account}")
    Student getByAccount(String account);

    @Insert("insert into student (username, account, password, sex, grade)" +
            "values (#{username}, #{account}, #{password}, #{sex}, #{grade})")
    void register(Student student);
}
