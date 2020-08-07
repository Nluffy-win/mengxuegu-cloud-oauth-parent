package com.mengxuegu.oauth2.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.sql.DataSource;

/**
 * Created by Y_Coffee on 2020/7/24
 */
@Configuration
@EnableAuthorizationServer //开始认证中心配置
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * 认证配置中心，配置允许被访问的认证服务器客户端
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                //用户中心的id，必须配置
                .withClient("mengxuegu-pc")
                //客户端密码，必须是密文，不能明文
                .secret(passwordEncoder.encode("mengxuegu-secret"))
                //资源id，能访问什么资源
                .resourceIds("product-server")
                //配置授权模式
                .authorizedGrantTypes("authorization_code", "password", "implicit", "client_credentials", "refresh_token")
                //访问资源id的标识，告诉能访问资源的什么，只是标识没有意义
                .scopes("all")
                //flase跳转到手动授权页面，true反过来
                .autoApprove(false)
                //客户端回调地址
                .redirectUris("http://www.baidu.com/");
        //配置第二个客户端
        //.and

    }

    /**
     * 服务器端点配置
     *
     * @param endpoints
     * @throws Exception
     */


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService customUserDetailsService;


    @Autowired//token管理策略
    private TokenStore tokenStore;

    @Autowired
    private DataSource dataSource;

    @Bean
    public AuthorizationCodeServices jdbcAuthorizationCodeServices() {
        return new JdbcAuthorizationCodeServices(dataSource);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //密码模式所需要的实例
        endpoints.authenticationManager(authenticationManager);

        //刷新令牌必须使用
        endpoints.userDetailsService(customUserDetailsService);

        //令牌管理方式
        endpoints.tokenStore(tokenStore);

        //将授权码存入数据库。使用后消失
        endpoints.authorizationCodeServices(jdbcAuthorizationCodeServices());
    }

}
