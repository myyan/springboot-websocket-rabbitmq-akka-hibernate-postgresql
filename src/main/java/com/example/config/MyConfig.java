package com.example.config;

import com.example.model.user.Haozi;
import com.example.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by chenhao on 2016/10/9.
 */

@Configuration
public class MyConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public Haozi haozi() {
        return new Haozi();
    }

    @Bean
    public Haozi haozii() {
        return new Haozi();
    }

}
