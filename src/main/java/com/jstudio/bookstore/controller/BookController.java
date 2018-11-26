package com.jstudio.bookstore.controller;

import com.jstudio.bookstore.config.AppConfig;
import com.jstudio.bookstore.controller.api.BookAPIController;
import com.jstudio.bookstore.domain.Book;
import com.jstudio.bookstore.domain.HttpResult;
import com.jstudio.bookstore.service.IAuthorService;
import com.jstudio.bookstore.service.IBookService;
import com.jstudio.bookstore.service.IStoreService;
import com.jstudio.bookstore.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Nick
 */
//@RestController
@Controller("book")
@RequestMapping("book")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(BookController.class);
    @Autowired
    BookAPIController apiController;
    @Autowired
    IBookService bookService;
    @Autowired
    IStoreService storeService;
    @Autowired
    IAuthorService authorService;

    @Autowired
    AppConfig appConfig;

    @GetMapping("/list")
    public String list(ModelMap modelMap) {
        modelMap.addAttribute("books", apiController.list().getData());
        return "book/list";
    }

    @GetMapping("/add")
    public String add(ModelMap modelMap) {
        modelMap.addAttribute("book", new Book());
        modelMap.addAttribute("authors", authorService.list());
        modelMap.addAttribute("stores", storeService.list());
        return "book/add";
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
