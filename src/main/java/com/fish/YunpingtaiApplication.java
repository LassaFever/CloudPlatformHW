package com.fish;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class YunpingtaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YunpingtaiApplication.class, args);
    }

}
