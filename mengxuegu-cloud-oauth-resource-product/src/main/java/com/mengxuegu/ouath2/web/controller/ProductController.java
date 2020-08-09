package com.mengxuegu.ouath2.web.controller;

import com.mengxuegu.base.result.MengxueguResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ProductController * @Description TODO * @Date 2020/8/9 21:45 * @Created by John
 */
@RestController("/product")
public class ProductController {

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('product:list')")
    public MengxueguResult list(){
        List<String> list = new ArrayList();
        list.add("眼镜");
        list.add("格子衬衫");
        list.add("双肩包");
        return MengxueguResult.ok(list);
    }
}
