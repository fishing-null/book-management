package com.example.book_management.enums;

public enum ResultCode {
    SUCCESS(0),
    FAIL(-1),
    UNLOGIN(-2);
    private Integer code;

    ResultCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
