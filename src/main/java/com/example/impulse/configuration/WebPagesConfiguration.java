package com.example.impulse.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebPagesConfiguration implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("main");
        registry.addViewController("/hello").setViewName("helloPage");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/auth-page").setViewName("auth-page");
    }
}
