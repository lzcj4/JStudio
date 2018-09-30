package com.jstudio.bookstore.domain;

import lombok.Data;


@Data
public class Store {
    private int id;
    private String name, address, phone;
}