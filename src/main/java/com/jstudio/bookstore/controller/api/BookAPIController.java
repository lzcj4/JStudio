package com.jstudio.bookstore.controller.api;

import com.jstudio.bookstore.config.AppConfig;
import com.jstudio.bookstore.domain.Book;
import com.jstudio.bookstore.domain.HttpResult;
import com.jstudio.bookstore.service.IBookService;
import com.jstudio.bookstore.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Nick
 */
@RestController("bookapi")
@RequestMapping("book/api")
public class BookAPIController {
    private Logger logger = LoggerFactory.getLogger(BookAPIController.class);

    @Autowired
    IBookService bookService;
    @Autowired
    AppConfig appConfig;

    @GetMapping("list")
    public HttpResult<List<Book>> list() {
        HttpResult<List<Book>> result = new HttpResult<>();
        result.setData(bookService.list());
        return result;
    }

    @PostMapping(value = "/add")
    public HttpResult<Book> add(@ModelAttribute Book book) {
        int id = bookService.add(book);
        book.setId(id);
        HttpResult<Book> result = new HttpResult<>();
        result.setData(book);
        return result;
    }

    @PostMapping(value = "/upload")
    public HttpResult<String> upload(@RequestParam("file") MultipartFile file, @RequestParam("text") String txt) {
        try {
            FileUtil.getInstance();
            String newPath = appConfig.getUploadRootPath() + file.getOriginalFilename();
            file.transferTo(new File(newPath));

//            FileUtil.saveFile(file.getInputStream(), appConfig.getUploadRootPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpResult<String> result = new HttpResult<>();
        result.setData("ok");
        return result;
    }

    @ExceptionHandler({DuplicateKeyException.class})
    private void globalExceptionHandler(ServletRequest req, Exception ex) {
        logger.error(ex.getMessage());
    }

}
