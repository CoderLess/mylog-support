package com.ibn.config;

import com.ibn.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.config
 * @date ：2020/1/27 20:02
 * @description：token相关拦截器
 * @version: 1.0
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");
    }
    /**
     * @author: RenBin
     * @description: 创建token相关的拦截器
     * @date: 2020/1/27 20:04
     */
    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
}
