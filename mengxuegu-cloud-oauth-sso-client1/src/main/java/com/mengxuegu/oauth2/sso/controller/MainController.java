package com.mengxuegu.oauth2.sso.controller;

import com.mengxuegu.base.result.MengxueguResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Y_Coffee on 2020/8/11
 */
@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @Autowired
    private OAuth2RestTemplate restTemplate;

    @GetMapping("/member")
    public String member(OAuth2RestTemplate restTemplate) {
        //因为get请求，如果是post请求就用postfor
        MengxueguResult result =
                restTemplate.getForObject("http://localhost:7001/product/list", MengxueguResult.class);
        System.out.println("result：" + result);
        return "member";
    }
}
