package com.example.book_management.config;

import com.example.book_management.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Slf4j
@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler
    public Result exception(Exception e){
        log.error("发生异常,e:{}",e);
        return Result.fail("内部错误");

    }

}
