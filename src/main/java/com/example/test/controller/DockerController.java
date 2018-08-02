package com.example.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mistaker
 * @description：
 * @create 2018/05/29
 */
@RestController
public class DockerController {

    @RequestMapping("/a")
    public String a(){
        return "Hello, Docker";
    }

}
