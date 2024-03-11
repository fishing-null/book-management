package com.example.book_management.controller;

import com.example.book_management.constant.Constants;
import com.example.book_management.enums.ResultCode;
import com.example.book_management.model.*;
import com.example.book_management.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/getBookListByPage")
    public Result getBookListByPage(PageRequest pageRequest, HttpSession session){
        log.info("查询翻页信息,pageRequest:{}",pageRequest);
        //逻辑处理
        if(pageRequest.getPageSize() <= 0 || pageRequest.getCurrentPage() < 1){
            return Result.fail("参数校验失败");
        }
        PageResult<BookInfo> bookInfoPageResult = null;
        try {
            bookInfoPageResult = bookService.selectBookInfoByPage(pageRequest);
            return Result.success(bookInfoPageResult);
        }catch (Exception e){
            log.error("查询翻页信息错误,e:{}",e);
            return Result.fail(e.getMessage());
        }

    }
    @RequestMapping("/addBook")
    public String addBook(BookInfo bookInfo){
        log.info("接收到图书请求, bookInfo:{}",bookInfo);
        if(!StringUtils.hasLength(bookInfo.getBookName())
                || !StringUtils.hasLength(bookInfo.getAuthor())
                || bookInfo.getCount() < 0
                || bookInfo.getPrice() == null
                || !StringUtils.hasLength(bookInfo.getPublish()))
        {
                return "插入参数失败,请检查入参";
        }
        Integer result = bookService.addBook(bookInfo);
        if(result <= 0){
            log.error("添加图书出错:bookInfo:{}",bookInfo);
            return "添加图书出错,请联系管理人";
        }
        return "";
    }

    @RequestMapping("/queryBookInfoById")
    public BookInfo queryBookInfoById(Integer bookId){
        log.info("根据id查询图书,bookId:{}",bookId);
        try {
            BookInfo bookInfo = bookService.queryBookInfoById(bookId);
            return bookInfo;
        }catch (Exception e){
            log.error("查询图书失败,e:{}",e);
        }
        return null;
    }

    /**
     * 更新图书 & 逻辑删除
     * @param bookInfo
     * @return
     */
    @RequestMapping("/updateBook")
    public String updateBook(BookInfo bookInfo){
        log.info("接收到更新图书的请求,bookInfo:{}",bookInfo);
        Integer result = bookService.updateBook(bookInfo);
        if(result == 0){
            log.error("更新图书失败,请联系管理员");
            return "更新图书失败,请联系管理员";
        }
        return "";
    }

    /**
     * 批量删除图书
     * @param ids
     * @return
     */
    @RequestMapping("/batchDelete")
    public String batchBook(@RequestParam List<Integer> ids){
        log.info("接受请求,批量删除图书,图书ID：{}",ids);
        Integer result = bookService.batchDelete(ids);
        if(result <= 0){
            log.error("批量删除失败,请联系管理员");
            return "更新批量删除失败,请联系管理员";
        }
        return "";
    }
}
