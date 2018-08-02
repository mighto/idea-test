package com.example.test.cache;

import java.io.Serializable;

/**
 * @author mistaker
 * @description：
 * @create 2018/03/21
 */
public class User implements Serializable {

    private String userId;
    private String userName;
    private int age;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
