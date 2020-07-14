package com.fish.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

//@Component
@WebFilter(value = {"/antionLogin", "/actionMyFilter"})
public class MyFilter extends HttpFilter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("hello filter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
