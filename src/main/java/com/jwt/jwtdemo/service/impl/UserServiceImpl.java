package com.jwt.jwtdemo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jwt.jwtdemo.entity.User;
import com.jwt.jwtdemo.mapper.UserMapper;
import com.jwt.jwtdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LowTaste
 * @since 2021-09-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User login(User user) {
        if (userMapper.login(user) != null){
            System.out.println(userMapper.login(user));
            return userMapper.login(user);
        }
        System.out.println("没查到");
        throw new RuntimeException("认证失败");
    }
}
