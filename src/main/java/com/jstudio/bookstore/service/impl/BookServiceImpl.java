package com.jstudio.bookstore.service.impl;

import com.jstudio.bookstore.data.BookMapper;
import com.jstudio.bookstore.domain.Book;
import com.jstudio.bookstore.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends AbstractServiceImpl<Book>
        implements IBookService {
    @Autowired
    public BookServiceImpl(BookMapper bookMapper) {
        super(bookMapper);
    }
}
