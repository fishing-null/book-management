package com.example.book_management.mapper;

import com.example.book_management.model.BookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookInfoMapper {
    /**
     *
     * 获取当前页纪录
     */
    @Select("select * from book_info where status != 0 " +
            "order by id asc limit #{offset},#{pageSize}")
    List<BookInfo> selectBookInfoByPage(Integer offset, Integer pageSize);

    /**
     *
     * 获取总记录数
     */
    @Select("select count(1) from book_info where status != 0")
    Integer count();
}
