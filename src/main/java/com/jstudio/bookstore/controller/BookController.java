package com.jstudio.bookstore.controller;

import com.jstudio.bookstore.domain.Book;
import com.jstudio.bookstore.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import java.util.List;

/**
 * @author Nick
 */
@RestController
public class BookController {

    private Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    IBookService bookService;

    @RequestMapping("/list")
    public List<Book> list() {
        return bookService.list();
    }

    @RequestMapping("/add")
    public Book add(@RequestBody Book book) {
//        Book book = new Book();
//        book.setTitle("Book B");
        int id = bookService.add(book);
        return book;
    }

    @ExceptionHandler({DuplicateKeyException.class})
    private void globalExceptionHandler(ServletRequest req, Exception ex) {
        logger.error(ex.getMessage());
    }

}
