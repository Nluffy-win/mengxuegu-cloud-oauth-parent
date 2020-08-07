package com.mengxuegu.oauth2.server.config;

import com.mengxuegu.oauth2.server.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 安全配置中心，配置用户登录的密码账号授权模式
 * Created by Y_Coffee on 2020/7/24
 */

@EnableWebSecurity //自带Configuration注解
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth.inMemoryAuthentication()
//
//                //测试指定用户名
//                .withUser("admin")
//
//                //测试指定2密码
//                .password(passwordEncoder.encode("123"))
//
//                //测试可访问资源，只是标识
//                .authorities("product");

        auth.userDetailsService(customUserDetailsService);
    }

    /**
     * 开启密码模式需要这个bean
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



}
