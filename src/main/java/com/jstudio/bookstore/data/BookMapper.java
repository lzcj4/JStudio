package com.jstudio.bookstore.data;

import com.jstudio.bookstore.domain.Book;
import java.util.List;


public interface BookMapper {
    int add(Book book);

    List<Book> listAll();
}
