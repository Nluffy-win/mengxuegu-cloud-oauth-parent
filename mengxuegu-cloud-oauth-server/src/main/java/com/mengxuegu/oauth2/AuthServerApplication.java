package com.mengxuegu.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Y_Coffee on 2020/7/24
 *
 * @author CoffeeY
 */
@SpringBootApplication
@EnableEurekaClient //注册中心的客户端
public class AuthServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }

//    @Bean
//    public HttpFirewall allowUrlSemicolonHttpFirewall() {
//        StrictHttpFirewall firewall = new StrictHttpFirewall();
//        firewall.setAllowSemicolon(true);
//        return firewall;
//    }
}
