package com.example.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author mistaker
 * @description：
 * @create 2018/08/02
 */
@RestController
public class ThreadController {

    Logger logger = LoggerFactory.getLogger(ThreadController.class);

    private int num = 2;

    @RequestMapping("/thread")
    private Map threadTest(){
        Long id = Thread.currentThread().getId();
        logger.info(String.format("id: %s", id));
        Map map = new HashMap();
        map.put("time", new Date());

        Random random = new Random();
        int time = random.nextInt(5);
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int result = num --;
        map.put("id", id);
        map.put("sleep", time);
        map.put("num", num);
        map.put("result", result);
        return map;
    }
}
