package com.example.book_management.config;

import com.example.book_management.interceptor.Logininterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private Logininterceptor logininterceptor;

    private static List<String> excludePath = Arrays.asList("/user/login",
            "/css/*",
            "/js/*",
            "/pic/*",
            "/**/*.html");
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logininterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePath);
    }
}
