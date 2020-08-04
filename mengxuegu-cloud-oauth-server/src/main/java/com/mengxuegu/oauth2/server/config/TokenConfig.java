package com.mengxuegu.oauth2.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * Created by Y_Coffee on 2020/7/27
 */
@Configuration
public class TokenConfig {

    private RedisConnectionFactory redisConnectionFactory;

    public TokenStore tokenStore(){
        return new RedisTokenStore(redisConnectionFactory);
    }
}
