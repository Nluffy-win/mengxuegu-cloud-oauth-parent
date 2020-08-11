package com.mengxuegu.oauth2.sso.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 单点登录
 * Created by Y_Coffee on 2020/8/11
 */
@EnableOAuth2Sso
@Configuration
public class SsoSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                //首页所有人都可以访问
                .antMatchers("/").permitAll()

                //其他的需要认证才可以访问
                .anyRequest().authenticated()


                .and()
                .logout()
                //当前应用退出后，会交给某个处理
                // 请求认证服务器将用户进行退出
                .logoutSuccessUrl("http://localhost:8090/auth/logout")


                .and()
                //因为是跨域访问退出post，想用get必须关闭跨域
                .csrf().disable()
        ;
    }
}
