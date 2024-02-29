package com.example.book_management.enums;

public enum BookStatusEnum {
    DELETED(0,"删除"),
    NORMAL(1,"可借阅"),
    FORBIDDEN(2,"不可借阅")
    ;
    private int code;
    private String name;

    public int getCode() {
        return code;
    }

    BookStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static BookStatusEnum getNameByCode(int code){
        switch (code){
            case 0: return BookStatusEnum.DELETED;
            case 1: return BookStatusEnum.NORMAL;
            case 2: return BookStatusEnum.FORBIDDEN;
            default:
                return BookStatusEnum.FORBIDDEN;
        }
    }
}
