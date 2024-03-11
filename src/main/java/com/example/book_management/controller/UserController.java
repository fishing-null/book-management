package com.example.book_management.controller;

import com.example.book_management.constant.Constants;
import com.example.book_management.model.UserInfo;
import com.example.book_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public boolean login(String userName, String password, HttpSession session) {
        //账号密码为空直接返回false
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)){
            return false;
        }
        UserInfo userInfo = userService.getUserInfoByName(userName);
        //根据用户名查找用户信息 比对密码是否正确
        if(userInfo == null || userInfo.getId() <= 0) return false;
        //校验成功
        if(password.equals(userInfo.getPassword())) {
            userInfo.setPassword("");
            session.setAttribute(Constants.SESSION_USER_KEY,userInfo);
            return true;
        }
        return false;
    }
}
