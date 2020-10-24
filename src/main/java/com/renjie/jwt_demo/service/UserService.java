package com.renjie.jwt_demo.service;

import com.renjie.jwt_demo.entity.User;

/**
 * @Author Fan
 * @Date 2020/10/23
 * @Description:
 */
public interface UserService {
    User login(User user);
}
