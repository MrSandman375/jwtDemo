package com.renjie.jwt_demo.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.renjie.jwt_demo.entity.User;
import com.renjie.jwt_demo.service.UserService;
import com.renjie.jwt_demo.utils.JWTutils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Fan
 * @Date 2020/10/23
 * @Description:
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/login")
    public Map<String,Object> login(User user){
        Map<String,Object> map = new HashMap<>();
        try {
            User userDB = userService.login(user);
            Map<String,String> payload = new HashMap<>();
            payload.put("id",userDB.getId().toString());
            payload.put("userName",userDB.getUserName());
            //生成JWT令牌
            String token = JWTutils.getToken(payload);
            map.put("token",token);
            map.put("state",true);
            map.put("msg","认证成功");
        } catch (Exception e){
            map.put("state",false);
            map.put("msg",e.getMessage());
        }
        return map;
    }

    @PostMapping("/user/test")
    public Map<String,Object> test(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        String token = request.getHeader("token");
        DecodedJWT tokenInfo = JWTutils.verify(token);
        String userName = tokenInfo.getClaim("userName").asString();
        map.put("msg","请求成功");
        map.put("userName",userName);
        return map;
    }
}
