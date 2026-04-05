package com.film.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Explicitly map /css/** to the static/css folder
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/");

        // Map /js/** if you add JS files later
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/static/js/");

        // Map /images/** if you add images later
        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/static/images/");
    }
}