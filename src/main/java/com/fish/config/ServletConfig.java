package com.fish.config;

import com.fish.filter.MyFilter;
import com.fish.listener.MyListener;
import com.fish.web.servletComponent.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

//@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean getServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();

        registrationBean.setServlet(new MyServlet());
        registrationBean.setUrlMappings(Arrays.asList("/myservlet"));


        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean getFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/tologin", "/myfilter"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean getListener() {
        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean();
        registrationBean.setListener(new MyListener());
        return registrationBean;
    }
}
