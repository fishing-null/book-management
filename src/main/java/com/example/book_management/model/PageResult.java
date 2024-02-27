package com.example.book_management.model;

import lombok.Data;

import java.util.List;
@Data
public class PageResult<T> {
    private int total;
    private List<T> records;

    public PageResult(int total, List<T> records) {
        this.total = total;
        this.records = records;
    }

}
