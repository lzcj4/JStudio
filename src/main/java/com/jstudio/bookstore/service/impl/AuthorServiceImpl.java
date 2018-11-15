package com.jstudio.bookstore.service.impl;

import com.jstudio.bookstore.data.AuthorMapper;
import com.jstudio.bookstore.data.BookMapper;
import com.jstudio.bookstore.domain.Author;
import com.jstudio.bookstore.domain.Book;
import com.jstudio.bookstore.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl extends AbstractServiceImpl<Author>
        implements IAuthorService {
    @Autowired
    public AuthorServiceImpl(AuthorMapper authorMapper) {
        super(authorMapper);
    }
}


