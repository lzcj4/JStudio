package com.jstudio.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@RequestMapping("setting")
@Controller
public class SettingController {
    @PostMapping("/language")
    public String list(HttpServletRequest request, @RequestParam("lang") String lang) {
        HttpServletRequest request2 = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes())
                .getRequest();

        if (StringUtils.isEmpty(lang)) {
            lang = request.getParameter("lang");
        }
        if ("cn".equals(lang)) {
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new
                    Locale("zh", "CN"));
        } else if ("en".equals(lang)) {
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new
                    Locale("en", "US"));
        }
        return "redirect:/book/add";
    }
}
