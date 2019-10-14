package com.minghai.mybatisplusdemo.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Book {
    //编号
    private long id;
    //书名
    private String bookName;
    //作者
    private String author;
    //发布日期
    private LocalDateTime publishDate;
    //价格
    private Double price;
}