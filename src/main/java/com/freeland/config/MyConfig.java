package com.freeland.config;

import com.freeland.model.user.Haozi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
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
