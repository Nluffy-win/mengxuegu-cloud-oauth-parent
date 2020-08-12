package com.mengxuegu.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by Y_Coffee on 2020/8/12
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy //开启zuul的功能
public class ZuulServer_7001 {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServer_7001.class, args);
    }
}
