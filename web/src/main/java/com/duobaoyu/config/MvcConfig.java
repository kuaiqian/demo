package com.duobaoyu.config;

import com.duobaoyu.argumentResolver.AuthDataMehotdArgumentResolver;
import com.duobaoyu.interceptor.AuthDataInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author FS001338
 * @date 2020/10/30
 */
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {

    @Bean
    public AuthDataMehotdArgumentResolver authDataMehotdArgumentResolver(){
        return new AuthDataMehotdArgumentResolver();
    }

    @Bean
    public AuthDataInterceptor authDataInterceptor(){
        return new AuthDataInterceptor();
    }

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(authDataMehotdArgumentResolver());
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authDataInterceptor());
    }
}
