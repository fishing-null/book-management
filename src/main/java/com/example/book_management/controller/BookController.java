package com.example.book_management.controller;

import com.example.book_management.model.BookInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/book")
public class BookController {
    @RequestMapping("/getBookList")
    public List<BookInfo> getBookList(){
        List<BookInfo> bookInfos = mockData();
        for(BookInfo bookInfo:bookInfos){
            if(bookInfo.getStatus() == 1){
                bookInfo.setStatusCN("可借阅");
            }else{
                bookInfo.setStatusCN("不可借阅");
            }
        }
        return bookInfos;
    }

    private List<BookInfo> mockData() {
        List<BookInfo> bookInfos = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(1);
            bookInfo.setBookName("图书" + i);
            bookInfo.setAuthor("作者" + i);
            bookInfo.setCount(new Random().nextInt(200));
            bookInfo.setPrice(new BigDecimal(new Random().nextInt(100)));
            bookInfo.setPublish("出版社" + i);
            bookInfo.setStatus(i % 5 == 0 ? 2 : 1);
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }
}
