package com.example.csiec.mapper;

import com.example.csiec.pojo.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TeacherMapper {
    @Select("select * from teacher where username = #{username} and password = #{password}")
    Teacher login(Teacher teacher);

    @Select("select * from teacher where account = #{account}")
    Teacher getByAccount(String account);

    @Select("select * from teacher where username = #{username}")
    Teacher getByUsername(String username);

    @Insert("insert into teacher (account, username, password, sex, grade, subject)" +
            "values (#{account}, #{username}, #{password}, #{sex}, #{grade}, #{subject})")
    void register(Teacher teacher);
}
