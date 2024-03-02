package com.example.csiec.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String username;
    private String account;
    private String password;
    private Integer sex; //0表示女，1表示男
    private Integer grade; //年级 2021 2022
}


