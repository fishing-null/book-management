package com.example.book_management.service;

import com.example.book_management.dao.BookDao;
import com.example.book_management.mapper.BookInfoMapper;
import com.example.book_management.model.BookInfo;
import com.example.book_management.model.PageRequest;
import com.example.book_management.model.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Component
public class BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookInfoMapper bookInfoMapper;
    public List<BookInfo> getBookList(){
        List<BookInfo> bookInfos = bookDao.mockData();
        for(BookInfo bookInfo:bookInfos){
            if(bookInfo.getStatus() == 1){
                bookInfo.setStatusCN("可借阅");
            }else{
                bookInfo.setStatusCN("不可借阅");
            }
        }
        return bookInfos;
    }
    public PageResult<BookInfo> selectBookInfoByPage(PageRequest pageRequest) {
        if(pageRequest == null){
            return null;
        }
        Integer count = bookInfoMapper.count();
        List<BookInfo> bookInfos = bookInfoMapper.selectBookInfoByPage(pageRequest.getOffset(), pageRequest.getPageSize());
        PageResult<BookInfo> pageResult = new PageResult<BookInfo>(count,bookInfos);
        return pageResult;
    }
}
