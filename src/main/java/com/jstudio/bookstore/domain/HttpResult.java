package com.jstudio.bookstore.domain;

import lombok.Data;

@Data
public class HttpResult<T> {
    private int code;
    private String msg;
    private T data;
}
