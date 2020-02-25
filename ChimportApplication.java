package com.mifan2009.chimport;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//开启事务
@EnableTransactionManagement
//配置MyBatis-Plus MapperScan 注解，扫描指定包下面的mapper接口
@MapperScan("com.mifan2009.chimport.mapper")
@SpringBootApplication
public class ChimportApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(ChimportApplication.class, args);
    }


    @Override//为了打包springboot项目
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }



}
