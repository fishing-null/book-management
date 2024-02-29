package com.example.book_management.controller;

import com.example.book_management.model.BookInfo;
import com.example.book_management.model.PageRequest;
import com.example.book_management.model.PageResult;
import com.example.book_management.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/getBookListByPage")
    public PageResult<BookInfo> selectBookInfoByPage(PageRequest pageRequest){
        log.info("查询翻页信息,pageRequest:{}",pageRequest);
        //逻辑处理
        if(pageRequest.getPageSize() <= 0 || pageRequest.getCurrentPage() < 1){
            return null;
        }
        PageResult<BookInfo> bookInfoPageResult = null;
        try {
            bookInfoPageResult = bookService.selectBookInfoByPage(pageRequest);
        }catch (Exception e){
            log.error("查询翻页信息错误,e:{}",e);
        }
        return bookInfoPageResult;
    }
}
