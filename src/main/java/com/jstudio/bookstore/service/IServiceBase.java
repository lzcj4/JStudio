package com.jstudio.bookstore.service;

import java.util.List;

public interface IServiceBase<T> {
    int add(T item);

    T getById(long id);

    List<T> list();

    int update(T item);

    int delete(T item);
}
