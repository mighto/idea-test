package com.example.test.cache;

/**
 * @author mistaker
 * @description：
 * @create 2018/03/21
 */
public class UserMain {

    public static void main(String[] args){
        UserService userService = new UserService();

        //开始查询账号
        userService.getUserById("00100101");//第一次查询，应该是执行数据库查询
        userService.getUserById("00100101");//第二次查询，应该是直接从缓存中返回

        //重置缓存
        System.out.println("after reload ...");

        //应该是数据库查询
        userService.getUserById("00100101");
        //第二次查询，应该是直接从缓存中返回
        userService.getUserById("00100101");

    }

}
