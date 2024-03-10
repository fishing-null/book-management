package com.example.book_management.model;

import com.example.book_management.enums.ResultCode;
import lombok.Data;

@Data
public class Result {
    private ResultCode code;//0-成功 -1-失败 -2-未登录
    private String errMsg;
    private Object data;
}
