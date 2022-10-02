package com.springboot.config;

import com.springboot.interceptor.LoginInterceptor;
import com.springboot.resolver.CustomLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description:
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    /**
     * 注册自定义的LocaleResolver，组件名称必须为localeResolver
     *
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new CustomLocalResolver();
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/index.html", "/login")
                .excludePathPatterns("/assets/**", "/css/**", "/js/**");//放行静态资源
    }
}
