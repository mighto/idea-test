package com.example.test.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author mistaker
 * @description：
 * @create 2018/03/13
 */

//通过该注解将PreGeeetingAspect标识为一个切面
@Aspect
public class PreGreetAspect {

    //定义切点和增强类型
    @Before("execution(* greetTo(..))")
    //增强的横切逻辑
    public void beforeGreetint(){
        System.out.println("How are you");
    }

}
