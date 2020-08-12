package com.mengxuegu.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * Created by Y_Coffee on 2020/8/12
 * @author CoffeeY
 */
@SpringBootApplication
@EnableEurekaServer //注册服务中心
public class EurekaServer_6001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_6001.class,args);
    }
}
