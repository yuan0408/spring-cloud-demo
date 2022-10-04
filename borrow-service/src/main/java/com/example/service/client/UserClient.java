package com.example.service.client;

import com.example.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("userService")   //声明为userService服务的HTTP请求客户端
public interface UserClient {
    @RequestMapping("/user/{uid}")
    public User findUserById(@PathVariable("uid") int uid);
}
