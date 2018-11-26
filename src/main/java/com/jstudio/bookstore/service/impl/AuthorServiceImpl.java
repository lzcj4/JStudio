package com.jstudio.bookstore.service.impl;

import com.jstudio.bookstore.mapper.AuthorMapper;
import com.jstudio.bookstore.domain.Author;
import com.jstudio.bookstore.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends AbstractServiceImpl<Author>
        implements IAuthorService {
    @Autowired
    public AuthorServiceImpl(AuthorMapper authorMapper) {
        super(authorMapper);
    }
}


