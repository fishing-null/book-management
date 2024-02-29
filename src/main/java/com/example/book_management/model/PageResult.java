package com.example.book_management.model;

import lombok.Data;

import java.util.List;
@Data
public class PageResult<T> {
    private Integer total;
    private List<T> records;
    private PageRequest pageRequest;

    public PageResult(Integer total, List<T> records, PageRequest pageRequest) {
        this.total = total;
        this.records = records;
        this.pageRequest = pageRequest;
    }

}
