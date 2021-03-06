package com.mengxuegu.ouath2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 资源服务
 * @author CoffeeY
 * @Classname ProductResourceApplication * @Description TODO * @Date 2020/8/9 21:49 * @Created by John
 */
@SpringBootApplication
@EnableEurekaClient
public class ProductResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductResourceApplication.class, args);
    }
}
