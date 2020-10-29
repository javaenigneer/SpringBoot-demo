package com.codeworld.fc.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName MyBatisPlusConfig
 * Description TODO
 * Author Lenovo
 * Date 2020/10/29
 * Version 1.0
**/
@Configuration
public class MyBatisPlusConfig {
    // SQL执行效率插件
    @Bean
    public PerformanceInterceptor performanceInterceptor(){
        return new PerformanceInterceptor();
    }
    // 分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
