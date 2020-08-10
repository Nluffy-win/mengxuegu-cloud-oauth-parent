package com.mengxuegu.oauth2.server.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;

/**
 * Created by Y_Coffee on 2020/7/27
 */
@Configuration
public class TokenConfig {

//    @Autowired
//    token存入redis配置
//    private RedisConnectionFactory redisConnectionFactory;

    @Bean//将实例添加到容器
    @ConfigurationProperties(prefix = "spring.datasource")//注入属性值，value单个，ConfigurationProperties多个，指定前缀
    public DataSource dataSource() {
        return new DruidDataSource();
    }


    private static final String SIGNING_KEY = "mengxuegu-key";

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        //采取对称加密进行令牌签名，资源服务器也要此秘钥解密，校验令牌合法性
        //converter.setSigningKey(SIGNING_KEY);

        //非对称加密
        KeyStoreKeyFactory factory = new KeyStoreKeyFactory
                (new ClassPathResource("oauth2.jks"),"oauth2".toCharArray());
        converter.setKeyPair(factory.getKeyPair("oauth2"));
        return converter;
    }


    @Bean//将实例添加到容器
    public TokenStore tokenStore() {
//        将token存入redis的容器
//        return new RedisTokenStore(redisConnectionFactory);
//        return new JdbcTokenStore(dataSource());
        //jwt管理令牌
        return new JwtTokenStore(jwtAccessTokenConverter());
    }
}
