package com.jstudio.bookstore.mapper;

import java.util.List;


public interface IMapper<T> {

    int insert(T item);

    int delete(T item);

    int update(T item);

    List<T> getAll();

    T getById(long id);

}
