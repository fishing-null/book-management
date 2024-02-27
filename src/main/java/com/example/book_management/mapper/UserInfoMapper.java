package com.example.book_management.mapper;

import com.example.book_management.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {
    @Select("select * from user_info where user_name = #{name}")
    UserInfo selectUserByname(String name);
}
