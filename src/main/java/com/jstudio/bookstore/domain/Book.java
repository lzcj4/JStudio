package com.jstudio.bookstore.domain;

import lombok.Data;

@Data
public class Book {
    private long id;
    private String title;
    private Author author;
    private Store store;
}
