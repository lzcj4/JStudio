package com.jstudio.bookstore.dao.mapper;

import com.jstudio.bookstore.domain.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

public interface BookMapper {
    @Insert("insert into t_book(id, title) values(#{id},#{title})")
    int add(Book book);
}
