package com.example.service.client.impl;

import com.example.entity.User;
import com.example.service.client.UserClient;
import org.springframework.stereotype.Component;

@Component
public class UserClientImpl implements UserClient {
    @Override
    public User findUserById(int uid) {
        return User.builder()
                .name("补救对象")
                .build();
    }
}
