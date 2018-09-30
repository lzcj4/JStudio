package com.jstudio.bookstore.domain;

import lombok.Data;

@Data
public class Author {
    private int id;
    private String name, address, phone;
    private boolean sex;
}
