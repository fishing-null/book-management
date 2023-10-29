package com.example.book_management;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public boolean login(String userName, String password, HttpSession session) {
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)){
            return false;
        }
        if("admin".equals(userName) && "admin".equals(password)){
            session.setAttribute("userName",userName);
            return true;
        }
        return false;
    }
}
