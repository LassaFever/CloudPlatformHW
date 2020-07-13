package com.fish.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration
public class MyLocalResovel implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String param = request.getParameter("1");
        String header = request.getHeader("Accept-Language");

        Locale locale = null;

        if (!StringUtils.isEmpty(param)){
            String[] spilt = param.split("_");
            locale = new Locale(spilt[0], spilt[1]);
        }else {
            String[] spilts = header.split(",");
            String[] spilt = spilts[0].split("-");
            locale = new Locale(spilt[0], spilt[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResovel();
    }
}
