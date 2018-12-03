package com.jstudio.bookstore.controller;

import com.jstudio.bookstore.domain.Book;
import com.jstudio.bookstore.service.IBookService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping
public class IndexController
        implements ApplicationContextAware,
        InitializingBean, DisposableBean,
        BeanFactoryPostProcessor, BeanPostProcessor {

    IBookService bookService;

    /**
     * TODO:   BeanFactoryPostProcessor 导致Autowired不干活
     */

    public IndexController(@Autowired IBookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute
    public Book getBook(@RequestParam long id) {
        return this.bookService.getById(id);
    }

    @GetMapping("/")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response, ModelMap m) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("hi", "My Test");
        return mav;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ((AnnotationConfigServletWebServerApplicationContext) applicationContext).setAllowBeanDefinitionOverriding(false);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }


    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
