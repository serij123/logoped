package com.ssmelnikov.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Melnikov_S on 21.09.2017.
 */
@Configuration
public class ViewControllersConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/signup").setViewName("signup");
        registry.addViewController("/user_created").setViewName("user_created");
        registry.addViewController("/").setViewName("forward:/index.html");
    }
}
