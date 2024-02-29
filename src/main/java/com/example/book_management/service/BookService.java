package com.example.book_management.service;

import com.example.book_management.enums.BookStatusEnum;
import com.example.book_management.mapper.BookInfoMapper;
import com.example.book_management.model.BookInfo;
import com.example.book_management.model.PageRequest;
import com.example.book_management.model.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Slf4j
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
        if(bookInfos != null && bookInfos.size() > 0){
            for (BookInfo bookInfo:bookInfos){
                bookInfo.setStatusCN(BookStatusEnum.getNameByCode(bookInfo.getStatus()).getName());
            }
        }
        return pageResult;
    }

    public Integer addBook(BookInfo bookInfo) {
        Integer result = null;
        try{
            result = bookInfoMapper.insertBook(bookInfo);
            if(result <= 0){
                log.error("添加图书出错:bookInfo:{}",bookInfo);
            }
        }catch(Exception e){
            log.error("添加图书出错,e:{}",e);
        }
        return result;
    }
}
