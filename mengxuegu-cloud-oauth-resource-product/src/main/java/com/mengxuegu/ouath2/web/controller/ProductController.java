package com.mengxuegu.ouath2.web.controller;

import com.mengxuegu.base.result.MengxueguResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CoffeeY
 * @Classname ProductController * @Description TODO * @Date 2020/8/9 21:45 * @Created by John
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/list")
    //@PreAuthorize("hasAuthority('product:list')")//资源访问权限
    public MengxueguResult list(Principal principal) {
        List<String> list = new ArrayList();
        list.add("眼镜");
        list.add("格子衬衫");
        list.add("双肩包");
        list.add(principal.getName());
        return MengxueguResult.ok(list);

    }

}
