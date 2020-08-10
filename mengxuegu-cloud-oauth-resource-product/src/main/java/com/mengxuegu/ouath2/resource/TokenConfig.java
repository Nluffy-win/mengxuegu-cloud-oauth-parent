package com.mengxuegu.ouath2.resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * Created by Y_Coffee on 2020/7/27
 */
@Configuration
public class TokenConfig {


    private static final String SIGNING_KEY = "mengxuegu-key";

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        //采取对称加密进行令牌签名，资源服务器也要此秘钥解密，校验令牌合法性
        converter.setSigningKey(SIGNING_KEY);
        return converter;
    }


    @Bean//将实例添加到容器
    public TokenStore tokenStore() {
        //jwt管理令牌
        return new JwtTokenStore(jwtAccessTokenConverter());
    }
}