package com.jstudio.bookstore.service.impl;

import com.jstudio.bookstore.data.IMapper;
import com.jstudio.bookstore.data.StoreMapper;
import com.jstudio.bookstore.domain.Store;
import com.jstudio.bookstore.service.IServiceBase;
import com.jstudio.bookstore.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int update(T item) {
        return this.mapper.update(item);
    }

    @Override
    public int delete(T item) {
        return this.mapper.delete(item);
    }
}
