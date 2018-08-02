package com.example.test.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mistaker
 * @description：
 * @create 2018/03/21
 */
@Service
public class UserService {

    @Autowired
    CacheService cacheService;

    @Cacheable(cacheNames = "userCache", key = "#p0")
    public User getUserById(String userId){
        System.out.println("get from cache ... " + userId);
        return getFromDB(userId);
    }

    public String b(){
        String a = "a";
        String b = "b";
        cacheService.put("bCache", a, b);
//        Cache cache = cacheService.getCache("bCache");
        System.out.println(cacheService.get("bCache", a).toString());
        return "com";
    }

    @Cacheable(cacheNames = "cCache")
    public String c(){
        String c = "c";
        User user = new User();
        user.setUserName(c);
        return c;
    }


    private User getFromDB(String userId){
        System.out.println("real querying db..." + userId);
        User user = new User();
        user.setUserId(userId);
        user.setAge(13);
        user.setUserName("不知道");
        return user;
    }

}
