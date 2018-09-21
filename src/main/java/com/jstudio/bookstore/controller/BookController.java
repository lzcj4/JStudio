package com.jstudio.bookstore.controller;

import com.jstudio.bookstore.domain.Book;
import com.jstudio.bookstore.service.IBookService;
import com.jstudio.bookstore.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import java.util.logging.Logger;

/**
 * @author Nick
 */
@RestController
public class BookController {

    private Logger logger = Logger.getLogger(BookController.class.getName());

    @Autowired
    IBookService bookService;

    @RequestMapping("/list")
    public String list() {
        Book b = new Book();
        b.setTitle("Book B");
        int id = bookService.add(b);
        return "Hello Spring Boot" + id;
    }

    @ExceptionHandler({DuplicateKeyException.class})
    private void globalExceptionHandler(ServletRequest req, Exception ex) {
        logger.warning(ex.getMessage());
    }
}
