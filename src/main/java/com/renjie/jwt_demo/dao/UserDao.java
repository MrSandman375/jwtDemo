package com.renjie.jwt_demo.dao;

import com.renjie.jwt_demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Fan
 * @Date 2020/10/23
 * @Description:
 */
@Mapper
public interface UserDao {
    User login(User user);
}

