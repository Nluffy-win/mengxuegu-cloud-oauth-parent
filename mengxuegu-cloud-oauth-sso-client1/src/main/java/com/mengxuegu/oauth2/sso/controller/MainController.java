package com.mengxuegu.oauth2.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Y_Coffee on 2020/8/11
 */
@Controller
public class MainController {

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/member")
    public String member(){
        return "member";
    }
}
