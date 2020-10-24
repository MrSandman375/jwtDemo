package com.renjie.jwt_demo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Fan
 * @Date 2020/10/23
 * @Description:
 */
@Data
@Accessors(chain = true)
public class User {
    private Integer id;
    private String userName;
    private String password;
}
