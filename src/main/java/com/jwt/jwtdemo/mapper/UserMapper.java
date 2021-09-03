package com.jwt.jwtdemo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jwt.jwtdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LowTaste
 * @since 2021-09-03
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User login(User user);
}
