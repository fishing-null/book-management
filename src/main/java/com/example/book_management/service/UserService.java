package com.example.book_management.service;

import com.example.book_management.mapper.UserInfoMapper;
import com.example.book_management.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    public UserInfo getUserInfoByName(String name){
        return userInfoMapper.selectUserByname(name);

    }
}
