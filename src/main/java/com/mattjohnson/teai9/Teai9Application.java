package com.mattjohnson.teai9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Teai9Application {

    public static void main(String[] args) {
        SpringApplication.run(Teai9Application.class, args);

    }

}
