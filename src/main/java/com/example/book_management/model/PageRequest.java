package com.example.book_management.model;

import lombok.Data;

@Data
public class PageRequest {
    private Integer currentPage = 1;
    private Integer pageSize = 10;
    private Integer offset;
    public Integer getOffset(){
        Integer offset = (currentPage - 1) * pageSize;
        return offset;
    }
}
