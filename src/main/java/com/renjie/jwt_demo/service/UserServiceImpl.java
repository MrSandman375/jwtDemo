package com.renjie.jwt_demo.service;

import com.renjie.jwt_demo.dao.UserDao;
import com.renjie.jwt_demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Fan
 * @Date 2020/10/23
 * @Description:
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {
        User userDB = userDao.login(user);
        if (userDB!=null){
            return userDB;
        }
        throw new RuntimeException("登陆失败");
    }
}
