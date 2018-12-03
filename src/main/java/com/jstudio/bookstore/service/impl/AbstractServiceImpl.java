package com.jstudio.bookstore.service.impl;

import com.jstudio.bookstore.mapper.IMapper;
import com.jstudio.bookstore.service.IServiceBase;

import java.util.List;


public abstract class AbstractServiceImpl<T> implements IServiceBase<T> {
    IMapper<T> mapper;

    public AbstractServiceImpl(IMapper<T> mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<T> list() {
        return this.mapper.getAll();
    }

    @Override
    public int add(T item) {
        return this.mapper.insert(item);
    }

    @Override
    public T getById(long id) {
        return this.mapper.getById(id);
    }

    @Override
    public int update(T item) {
        return this.mapper.update(item);
    }

    @Override
    public int delete(T item) {
        return this.mapper.delete(item);
    }
}
