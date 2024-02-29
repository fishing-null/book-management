package com.example.book_management.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookInfo {
    private Integer id;
    private String bookName;
    private String author;
    private Integer count;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;
    private String publish;
    private Integer status;
    private String statusCN;
}
