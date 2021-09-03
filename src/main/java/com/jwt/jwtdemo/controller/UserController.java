package com.jwt.jwtdemo.controller;


import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jwt.jwtdemo.entity.User;
import com.jwt.jwtdemo.service.UserService;
import com.jwt.jwtdemo.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.management.ObjectName;
import javax.servlet.http.HttpServletRequest;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LowTaste
 * @since 2021-09-03
 */
@RestController
@Slf4j
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("login")
    public Map<String,Object> login(User user){
        System.out.println(user);
        log.info("用户名:" + user.getName());
        log.info("密码:" + user.getPassword());
        Map<String,Object> map = new HashMap<>();
        try {
            User user1 = userService.login(user);
            Map<String,String> playLoad = new HashMap<>();
            playLoad.put("id", user1.getId().toString());
            playLoad.put("name", user1.getName());
            String token = JWTUtils.getToken(playLoad);
            map.put("state",true);
            map.put("msg","认证成功");
            map.put("token",token);
        } catch (Exception e){
            map.put("state",false);
            map.put("msg",e.getMessage());
        }
        return map;
    }

    @PostMapping("test")
    public Map<String,Object> test(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        log.info("当前token = \n" + request.getHeader("token"));
        map.put("state",true);
        map.put("msg","Success! Cross Interceptor");
        return map;
    }
}

