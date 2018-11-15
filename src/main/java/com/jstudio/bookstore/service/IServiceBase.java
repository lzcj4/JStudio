package com.jstudio.bookstore.service;

import com.jstudio.bookstore.domain.Book;

import java.util.List;

public interface IServiceBase<T> {
    int add(T item);

    List<T> list();

    int update(T item);

    int delete(T item);
}
