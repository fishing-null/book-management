package com.example.book_management.service;

import com.example.book_management.dao.BookDao;
import com.example.book_management.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Component
public class BookService {
    @Autowired
    private BookDao bookDao;
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
}
