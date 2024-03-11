package com.example.book_management.model;

import com.example.book_management.enums.ResultCode;
import lombok.Data;

@Data
public class Result<T> {
    private ResultCode code;//0-成功 -1-失败 -2-未登录
    private String errMsg;
    private Object data;
    public static Result success(Object data){
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setErrMsg("");
        result.setData(data);
        return result;
    }
    public static Result unlogin(){
        Result result = new Result();
        result.setCode(ResultCode.UNLOGIN);
        result.setErrMsg("用户未登录");
        result.setData(null);
        return result;
    }
    public static Result fail(String errMsg){
        Result result = new Result();
        result.setCode(ResultCode.FAIL);
        result.setErrMsg(errMsg);
        return result;
    }
}
