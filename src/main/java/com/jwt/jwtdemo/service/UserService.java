package com.jwt.jwtdemo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.jwt.jwtdemo.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LowTaste
 * @since 2021-09-03
 */
public interface UserService extends IService<User> {
    User login(User user);
}
