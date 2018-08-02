package com.example.test.controller;

import com.example.test.cache.User;
import com.example.test.cache.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mistaker
 * @description：
 * @create 2018/05/31
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    UserService userService;

    @RequestMapping("/a")
    public User a(){
        return userService.getUserById("00001");
    }

    @RequestMapping("/b")
    public String b(){
        return userService.b();
    }

    @RequestMapping("/c")
    public String c(){
        return userService.c();
    }

}
