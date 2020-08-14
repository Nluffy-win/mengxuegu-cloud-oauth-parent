package com.mengxuegu.oauth2.filter;


import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 请求资源前,先通过此 过滤器进行用户信息解析和校验 转发
 * Created by Y_Coffee on 2020/8/13
 */
@Component // 不要少了,将整个类注入spring容器，bean是注入一个方法进spring容器
public class AuthenticationFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    //打印日志
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Object run() throws ZuulException {
        //获取认证信息Authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 如果解析到令牌就会封装到OAuth2Authentication对象
        //判断
        if (!(authentication instanceof OAuth2Authentication)) {
            return null;
        }
        logger.info("网关获取的认证对象" + authentication);
        //获取用户名,没有任何信息
        Object principal = authentication.getPrincipal();


        //获取所有权限
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        //为了方便以后资源服务器更好转换
        Set<String> authoritySet = AuthorityUtils.authorityListToSet(authorities);


        //获取详情
        Object details = authentication.getDetails();

        //封装信息
        Map<String, Object> result = new HashMap<>();
        result.put("principal", principal);
        result.put("authorities", authoritySet);
        result.put("details", details);

        //传递给下游微服务

        // 获取当前请求上下文
        RequestContext context = RequestContext.getCurrentContext();
        // 将用户信息和权限信息转成json,再通过base64进行编码（也可以不编码）
        String base64 = Base64Utils.encodeToString(JSON.toJSONString(result).getBytes());
        // 添加到请求头
        context.addZuulRequestHeader("auth-token", base64);
        return null;
    }
}

