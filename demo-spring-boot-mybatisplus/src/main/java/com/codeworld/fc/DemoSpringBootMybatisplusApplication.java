package com.codeworld.fc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.codeworld.fc.mapper"})
public class DemoSpringBootMybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootMybatisplusApplication.class, args);
    }

}
