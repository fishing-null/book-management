package com.example.book_management.model;

import lombok.Data;

import java.util.Date;
@Data
public class UserInfo {
    private Integer id;
    private String userName;
    private String password;
    private String deleteFlag;
    private Date createTime;
    private Date updateTime;

}
