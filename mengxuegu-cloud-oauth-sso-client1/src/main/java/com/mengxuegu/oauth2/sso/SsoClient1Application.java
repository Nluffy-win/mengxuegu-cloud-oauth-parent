package com.mengxuegu.oauth2.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Y_Coffee on 2020/8/11
 * @author CoffeeY
 */
@EnableEurekaClient
@SpringBootApplication
public class SsoClient1Application {
    public static void main(String[] args) {
        SpringApplication.run(SsoClient1Application.class, args);
    }
}
