package com.renjie.jwt_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Fan
 * @Date 2020/10/23
 * @Description:
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(String userName, HttpServletRequest request){

        request.getSession().setAttribute("userName",userName);
        System.out.println(request.getSession().getAttribute(userName));
        return userName +"login ok";
    }



}
