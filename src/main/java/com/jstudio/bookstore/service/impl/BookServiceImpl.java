package com.jstudio.bookstore.service.impl;

import com.jstudio.bookstore.dao.mapper.BookMapper;
import com.jstudio.bookstore.domain.Book;
import com.jstudio.bookstore.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public int add(Book book) {
        return this.bookMapper.add(book);
    }
}
