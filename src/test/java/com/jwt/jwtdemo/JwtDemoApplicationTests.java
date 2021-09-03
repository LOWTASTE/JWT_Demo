package com.jwt.jwtdemo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jwt.jwtdemo.entity.User;
import com.jwt.jwtdemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.HashMap;

@SpringBootTest
class JwtDemoApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    void JwtGenerate(){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,600);
        HashMap<String,Object> header = new HashMap<>();
        header.put("type", "JWT");
        String token =
        JWT.create()
                // 过期时间
                .withExpiresAt(instance.getTime())
                // header
                .withHeader(header)
                // playLoad
                .withClaim("userId", "L")
                .withClaim("userName", "LT")
                // 签名
                .sign(Algorithm.HMAC256("@!wHAT12!@#"));
        System.out.println(token);
    }

    @Test
    void JwtVerify(){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("@!wHAT12!@#")).build();
        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE2MzA2NDE1NTIsInVzZXJOYW1lIjoiTFQiLCJ1c2VySWQiOiJMIn0.FglYj2Iovu3RRf5JqT9X3I_ZX9FeaJQiFpwhKK1xSqM");
        System.out.println(verify.getClaims().get("userId"));
        System.out.println(verify.getClaims().get("userName"));
        System.out.println("过期时间: " + verify.getExpiresAt());
    }

    @Autowired
    UserService userService;
    @Test
    public void findAll(){
        System.out.println(userService.list());
    }



}
