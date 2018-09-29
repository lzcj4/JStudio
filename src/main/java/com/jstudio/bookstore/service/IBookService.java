package com.jstudio.bookstore.service;

import com.jstudio.bookstore.domain.Book;

import java.util.List;

public interface IBookService {
    int add(Book book);

    List<Book> list();
}
