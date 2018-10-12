package com.jstudio.bookstore.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class WebConfigurerAdapter extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new WebConfigurerAdapter.RequestInterceptor()).addPathPatterns("/upload");
    }

    private static class RequestInterceptor extends HandlerInterceptorAdapter {
        public RequestInterceptor() {
            super();
        }

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            MultiValueMap<String, MultipartFile> multiMap = multiRequest.getMultiFileMap();
            multiMap.forEach((key, value) -> {
                if (value.size() > 0) {
                    MultipartFile file = (MultipartFile) value.get(0);
                }
            });
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
