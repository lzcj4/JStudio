package com.jstudio.bookstore.domain;

import lombok.Data;

@Data
public class Cover {
    private int id;
    private String name, file_path, comment;
}
