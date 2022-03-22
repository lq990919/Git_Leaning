package com.hr.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lq
 * @date 2021-07-19 - 16:00
 */
//Spring boot方式
@Configuration
@MapperScan("com.baomidou.cloud.service.*.mapper*")
public class MybatisPlusConfig {

    @Bean
     public PaginationInterceptor paginationInterceptor() {
            PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
            return paginationInterceptor;
     }

}
