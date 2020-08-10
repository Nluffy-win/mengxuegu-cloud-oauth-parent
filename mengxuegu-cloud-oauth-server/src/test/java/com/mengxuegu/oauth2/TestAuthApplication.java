package com.mengxuegu.oauth2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: 梦学谷 www.mengxuegu.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAuthApplication {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void testPwd() {
        System.out.println(passwordEncoder.encode("mengxuegu-secret"));
    }
    
    @Test
    public void testpass(){
        String p1 = passwordEncoder.encode("123");
        String p2 = "$10$rDkPvvAFV8kqwvKJzwlRv.i.q.wz1w1pz0SFsHn/55jNeZFQv/eCm";
        System.out.println(p1.equals(p2));

    }
}