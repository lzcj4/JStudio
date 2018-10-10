package com.jstudio.bookstore.interceptor;

import com.jstudio.bookstore.controller.BookController;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class WebConfigurerAdapter extends WebMvcConfigurationSupport {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new WebConfigurerAdapter.RequestInterceptor());
    }

    private static class RequestInterceptor extends HandlerInterceptorAdapter {
        public RequestInterceptor() {
            super();
        }

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {
            return super.preHandle(request, response, handler);
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response,
                               Object handler, ModelAndView modelAndView) throws Exception {
            super.postHandle(request, response, handler, modelAndView);
        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                    Object handler, Exception ex) throws Exception {
            super.afterCompletion(request, response, handler, ex);
        }

        @Override
        public void afterConcurrentHandlingStarted(HttpServletRequest request,
                                                   HttpServletResponse response, Object handler) throws Exception {
            super.afterConcurrentHandlingStarted(request, response, handler);
        }
    }
}
