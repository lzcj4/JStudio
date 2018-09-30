package com.jstudio.bookstore.controller;

import com.jstudio.bookstore.domain.Book;
import com.jstudio.bookstore.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public List<Book> list() {
        return bookService.list();
    }

    @RequestMapping(value = "/add")
    @PostMapping(value = "/add")
    public Book add(@RequestBody Book book) {
        int id = bookService.add(book);
        return book;
    }

    @ExceptionHandler({DuplicateKeyException.class})
    private void globalExceptionHandler(ServletRequest req, Exception ex) {
        logger.error(ex.getMessage());
    }

}
