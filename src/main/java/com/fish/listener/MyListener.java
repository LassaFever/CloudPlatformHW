package com.fish.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
//@Component
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context Init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context Destory");
    }
}
