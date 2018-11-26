package com.jstudio.bookstore.service.impl;

import com.jstudio.bookstore.domain.Book;
import com.jstudio.bookstore.mapper.BookMapper;
import com.jstudio.bookstore.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends AbstractServiceImpl<Book>
        implements IBookService {
    @Autowired
    public BookServiceImpl(BookMapper bookMapper) {
        super(bookMapper);
    }
}
