package com.example.book_management.service;

import com.example.book_management.mapper.BookInfoMapper;
import com.example.book_management.model.BookInfo;
import com.example.book_management.model.PageRequest;
import com.example.book_management.model.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BookService {
    @Autowired
    private BookInfoMapper bookInfoMapper;
    public PageResult<BookInfo> selectBookInfoByPage(PageRequest pageRequest) {
        if(pageRequest == null){
            return null;
        }
        Integer count = bookInfoMapper.count();
        List<BookInfo> bookInfos = bookInfoMapper.selectBookInfoByPage(pageRequest.getOffset(), pageRequest.getPageSize());
        PageResult<BookInfo> pageResult = new PageResult<BookInfo>(count,bookInfos,pageRequest);
        return pageResult;
    }
}
