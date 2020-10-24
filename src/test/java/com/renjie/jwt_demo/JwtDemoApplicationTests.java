package com.renjie.jwt_demo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

class JwtDemoApplicationTests {

    //生成jwt
    @Test
    void contextLoads() {

        Map<String,Object> map = new HashMap();
        map.put("alg","HS256");
        map.put("typ","JWT");
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE,60);
        String token = JWT.create()
                .withHeader(map)//header
                .withClaim("userId",123456)//payload
                .withClaim("userName","zhangsan")
                .withExpiresAt(instance.getTime())//令牌过期的时间
                .sign(Algorithm.HMAC256("!SD%DASDAS#r"));//签名
        System.out.println(token);
    }

    //验证签名
    @Test
    public void test(){
        //创建验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("!SD%DASDAS#r")).build();
        DecodedJWT verify = jwtVerifier.verify("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InpoYW5nc2FuIiwiZXhwIjoxNjAzNDQyNjk0LCJ1c2VySWQiOjEyMzQ1Nn0.1GIdcUN9psMiiXYNaHwrJxZSI2bfL0DSAPy4wRvMQP0");
        System.out.println(verify.getClaim("userName").asString());
        System.out.println(verify.getClaim("userId").asLong());
    }


}
